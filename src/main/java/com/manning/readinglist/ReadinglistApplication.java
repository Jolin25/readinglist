package com.manning.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

/**
 * @author jrl
 * @date 2022/2/13
 */
@SpringBootApplication
public class ReadinglistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);

    }

}
