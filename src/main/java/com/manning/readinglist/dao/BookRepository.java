package com.manning.readinglist.dao;

import com.manning.readinglist.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jrl
 * @date Create in 15:42 2022-2-16
 */
public interface BookRepository extends JpaRepository<Book, String> {
}
