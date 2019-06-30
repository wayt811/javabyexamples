package com.javabyexamples.spring.mvc1.interceptor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldIntercept_WhenMapped() throws Exception {
        mockMvc.perform(get("/api/stats"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotIntercept_WhenExcluded() throws Exception {
        mockMvc.perform(get("/api/stats"))
                .andExpect(status().isOk());
    }
}