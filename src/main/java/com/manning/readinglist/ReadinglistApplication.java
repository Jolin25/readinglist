package com.manning.readinglist;

import com.manning.readinglist.dao.ReaderRepository;
import com.manning.readinglist.pojo.Reader;
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
@SpringBootApplication
@Slf4j
public class ReadinglistApplication implements CommandLineRunner {
    @Autowired
    ReaderRepository readerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        Reader walt = readerRepository.findByUsername("walt");
        Iterable<Reader> all = readerRepository.findAll();
        log.info(all.toString());
    }
}
