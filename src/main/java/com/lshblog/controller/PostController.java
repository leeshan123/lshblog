package com.lshblog.controller;

import com.lshblog.domain.Post;
import com.lshblog.request.PostCreate;
import com.lshblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) throws Exception {

        postService.write(request);
    }


}
