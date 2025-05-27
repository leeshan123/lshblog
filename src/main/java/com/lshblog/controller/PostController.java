package com.lshblog.controller;

import com.lshblog.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//SSR -> jsp, thymeleaf
//SPA(Single Page Application) -> view, react
// vue -> vue+SSR = nuxt
// react -> react+SSR = next

@Slf4j
@RestController
public class PostController {


    @PostMapping("/posts")
    public Map<String,String> post(@RequestBody @Valid PostCreate params) throws Exception {
        log.info("params={}", params);


        return Map.of();
    }


}
