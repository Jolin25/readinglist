package com.manning.readinglist.controller;


import com.manning.readinglist.dao.ReadingListRepository;
import com.manning.readinglist.pojo.Book;
//import com.manning.readinglist.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author 小虫子的小日常
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Model model) {
        List<Book> all = readingListRepository.findAll();
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
//            model.addAttribute("reader", new Reader("craig", "craigfn", "craigpwd"));
        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(@RequestBody Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }

}
