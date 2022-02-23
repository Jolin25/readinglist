package com.manning.readinglist.controller;

import com.alibaba.fastjson.JSON;
import com.manning.readinglist.pojo.Book;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 1.测试内容：不含spring security的mvc测试，对readingList请求进行测试
 * 2.SpringMockMVC：能在一个近似真实的模拟Servlet容器中测试控制器，而不实际启动应用服务器。
 * 3.学习内容：
 * 3.1 注入了哪些实例：
 * WebMvcTest注解：注入了参数类的实例，但是类里面注入的bean没有跟着一起注入。这个可以理解成是spring在操作，不要理解成mock的操作。
 * SpringBootTest注解：注入了整个项目的实例
 * AutoConfigureMockMvc注解：用来自动配置mockmvc的
 * 3.2 Mock 和 springboot如何结合的： 通过spring boot test里的mockito，其实就是springboot用了mockito
 * 3.3 Mock 和 Mockito 的关系： Mockito应该是使用Mock的一种框架吧
 * 3.4 Mock : mock可以假装有一个实例，我的理解是，没有用spring来注入实例，而是用mock的原因是：spring在测试类里面注入实例不是连锁的（就比如注入了controller，但是里面用到的service实例就没有一起注入），mock直接了当，注入最上层的那个就好了（就直接把controller注入就好了）。
 * <p>
 * <p>
 * 参考资料：https://reflectoring.io/spring-boot-mock/
 *
 * @author jrl
 * @date Create in 10:20 2022-2-22
 */
@SpringBootTest
@AutoConfigureMockMvc
class MockMvcWebTestsOne {
    @Autowired
    private MockMvc mockMvc;

    /**
     * 模拟Spring MVC 向 Controller发送Http请求：
     * 向/readingList发送get请求
     *
     * @param
     * @return
     * @date 2022-2-22
     */
    @Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/readingList"))
                .andExpect(status().isOk()) // 就是http 返回200
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"));
    }

    @Test
    void testHomePagePost() throws Exception {
        Book book = new Book(Long.parseLong("1"),"a","testIsbn", "testTitle", "testAuthor", "testDescription");
        String toJSON = JSON.toJSON(book).toString();
         mockMvc.perform(post("/readingList")
                .contentType(APPLICATION_JSON)
                .content(toJSON))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/readingList"));
         mockMvc.perform(get("/readingList"))
                 .andExpect(model().attribute("books",contains(samePropertyValuesAs(book))));

    }
}
