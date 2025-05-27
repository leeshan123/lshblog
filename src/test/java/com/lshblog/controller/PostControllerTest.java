package com.lshblog.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 Hello World를 출력")
    void test() throws Exception {
        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"제목\", \"content\" : \"내용\"}")
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{}"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("/posts 요청시title 값은 필수다")
    void test2() throws Exception {
        // expected
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": null, \"content\" : null}")
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
                .andExpect(jsonPath("$.validation.content").value("컨텐츠를 입력해주세요."))

                .andDo(MockMvcResultHandlers.print());

    }


}