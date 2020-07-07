package com.validity.monolithstarter.rest;

import com.validity.monolithstarter.model.User;
import com.validity.monolithstarter.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Inject
    private HelloService helloService;

    @GetMapping("/hello")
    public String getHelloMessage() {
        return helloService.getHelloMessage();
    }

    @GetMapping("/csv/duplicates")
    @ResponseBody
    public List<User> duplicates() {
        List<User> userList = helloService.readCsv();
        return helloService.getDuplicates(userList).getDuplicates();
    }

    @GetMapping("/csv/clean")
    @ResponseBody
    public List<User> clean() {
        List<User> userList = helloService.readCsv();
        return helloService.getDuplicates(userList).getClean();
    }



}
