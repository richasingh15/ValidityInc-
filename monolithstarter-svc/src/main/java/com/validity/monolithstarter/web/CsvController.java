/**
 * Copyright (c) 2019 Validity Inc.
 * All rights reserved.
 */

package com.validity.monolithstarter.web;

import com.validity.monolithstarter.model.User;
import com.validity.monolithstarter.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CsvController {
    private static final Logger log = LoggerFactory.getLogger(CsvController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping("/csv")
    public String main(Model model) {
        List<User> userList = helloService.readCsv();
        model.addAttribute("userListDuplicates", helloService.getDuplicates(userList).getDuplicates());
        model.addAttribute("userListClean", helloService.getDuplicates(userList).getClean());
        return "csv";
    }
}
