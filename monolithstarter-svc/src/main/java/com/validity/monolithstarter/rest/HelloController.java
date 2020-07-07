package com.validity.monolithstarter.rest;

import com.validity.monolithstarter.model.User;
import com.validity.monolithstarter.service.HelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/csv/duplicates")
    @ResponseBody
    public ResponseEntity duplicates(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body( "Could not read file");
        }
        List<User> userList = helloService.readCsv(file);
        return ResponseEntity.ok().body(helloService.getDuplicates(userList).getDuplicates());
    }

    @PostMapping("/csv/clean")
    @ResponseBody
    public ResponseEntity clean(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body( "Could not read file");
        }
        List<User> userList = helloService.readCsv(file);
        return ResponseEntity.ok().body(helloService.getDuplicates(userList).getClean());
    }



}
