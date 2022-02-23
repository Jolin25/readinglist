package com.manning.readinglist;

//import com.manning.readinglist.dao.ReaderRepository;
//import com.manning.readinglist.pojo.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

/**
 * @author jrl
 * @date 2022/2/13
 */
@SpringBootApplication // 开启组件扫描和自动配置
@Slf4j
public class ReadinglistApplication implements CommandLineRunner {
//    @Autowired
//    ReaderRepository readerRepository;

    public static void main(String[] args) {
        // 负责启动 引导应用程序
        //SpringApplication 不仅加载应用程序上下文，还会开启日志、加载外部属性（application.yml）,以及其他Spring Boot 特性
        SpringApplication.run(ReadinglistApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        Reader walt = readerRepository.findByUsername("walt");
//        Iterable<Reader> all = readerRepository.findAll();
//        log.info(all.toString());
//        readerRepository.save(new Reader("Joly", "JolyJ", "123456"));
//        Iterable<Reader> all2 = readerRepository.findAll();
//        log.info(all2.toString());
    }
}
