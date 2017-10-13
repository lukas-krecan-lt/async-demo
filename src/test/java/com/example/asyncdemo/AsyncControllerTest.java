package com.example.asyncdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AsyncControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCall() throws Exception {
        MvcResult result = mockMvc.perform(get("/test"))
            .andExpect(request().asyncStarted())
            .andReturn();
        mockMvc.perform(asyncDispatch(result))
            .andExpect(content().string("value"))
            .andExpect(header().string(HttpHeaders.ETAG, notNullValue()));
    }

}