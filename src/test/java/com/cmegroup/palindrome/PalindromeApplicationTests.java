package com.cmegroup.palindrome;

import com.cmegroup.palindrome.model.PalindromeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
		import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class  PalindromeApplicationTests{

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		// You might want to clear your persistence file or reset any state here
	}

	@Test
	public void testCheckPalindrome_withValidPalindrome() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/palindrome/check")
						.param("username", "user1")
						.param("text", "madam"))
				.andExpect(status().isOk())
				.andReturn();

		String jsonResponse = result.getResponse().getContentAsString();
		System.out.println("jsonResponse "+jsonResponse);
		ObjectMapper objectMapper = new ObjectMapper();
		PalindromeResponse response = objectMapper.readValue(jsonResponse, PalindromeResponse.class);
		// Perform assertions on the Java object
		assertEquals("user1", response.getUsername());
		assertEquals("madam", response.getText());
		assertTrue(response.getPalindrome());
	}

	@Test
	public void testCheckPalindrome_withInvalidInput() throws Exception {
		mockMvc.perform(post("/api/palindrome/check")
						.param("username", "user1")
						.param("text", "madam123"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testCheckPalindrome_withNonPalindrome() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/palindrome/check")
						.param("username", "user1")
						.param("text", "hello"))
				.andExpect(status().isOk())
				.andReturn();

		String jsonResponse = result.getResponse().getContentAsString();
		System.out.println("jsonResponse "+jsonResponse);
		ObjectMapper objectMapper = new ObjectMapper();
		PalindromeResponse response = objectMapper.readValue(jsonResponse, PalindromeResponse.class);
		// Perform assertions on the Java object
		assertEquals("user1", response.getUsername());
		assertEquals("hello", response.getText());
		assertFalse(response.getPalindrome());
	}
}

