package com.manning.readinglist.dao;


import com.manning.readinglist.pojo.Book;
import com.manning.readinglist.pojo.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(Reader reader);

}
