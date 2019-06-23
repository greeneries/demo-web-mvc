package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
	
	@Autowired
	MockMvc mockMvc;

	//@Test
	public void login() throws Exception {
		mockMvc.perform(get("/login/1"))
		.andExpect(status().isOk())
		.andDo(print());
		
		
		mockMvc.perform(post("/login")
				.param("id", "1")
				.param("name", "moon"))
		.andExpect(status().isOk())
		.andDo(print());
		
		
		mockMvc.perform(post("/login2")
				.param("id", "2")
				.param("name", "jaein"))
		.andExpect(status().isOk())
		.andDo(print());
		
	}
	
	@Test
	public void binding() throws Exception {
		mockMvc.perform(post("/bindingTest")
				.param("id", "3")
				.param("age", "22"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	
	
}
