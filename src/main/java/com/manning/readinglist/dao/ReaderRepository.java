//package com.manning.readinglist.dao;
//
////import com.manning.readinglist.pojo.Reader;
//import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.Optional;
//
///**
// * 继承jpa对应的接口，泛型填pojo类和主键的类型,jpa会自动实现Reader相关的数据库操作
// *
// * @author jrl
// * @date Create in 15:36 2022-2-16
// */
//public interface ReaderRepository extends CrudRepository<Reader, String> {
//    Reader findByUsername(String username);
//}
