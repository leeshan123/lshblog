package com.lshblog.controller;

import com.lshblog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//SSR -> jsp, thymeleaf
//SPA(Single Page Application) -> view, react
// vue -> vue+SSR = nuxt
// react -> react+SSR = next

@Slf4j
@RestController
public class PostController {


    @PostMapping("/posts")
    public String post(@RequestBody PostCreate params){
        log.info("params={}", params);
        return "Hello World";
    }

//    @PostMapping("/posts")
//    public String post(PostCreate params){
//        log.info("params={}", params);
//        return "Hello World";
//    }

//    @PostMapping("/posts")
//    public String post(@RequestParam Map<String,String> params){
//        log.info("params={}", params);
//        return "Hello World";
//    }


}
