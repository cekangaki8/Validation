package com.porsetech.learning.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(FooController.class)
public class FooControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSetup(){
        assertNotNull(mvc);
    }


    @Test
    public void testFoo() throws Exception {
        mvc.perform(
                post("/foo")
                .content("{\"stringVariable\":\"\"}")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.stringVariable").value(nullValue(String.class)));
    }

    /**
     * TODO: Seems to indicate it is functional check if it is actually working, it is very MVC like, no?
     *
     * @throws Exception
     */
    @Test
    public void testFooRequest() throws Exception {
        mvc.perform(
                post("/fooRequest")
                        .content("{\"stringVariable\":\"\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.stringVariable").value(nullValue(String.class)));
    }


}