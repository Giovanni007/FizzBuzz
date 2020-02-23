package org.example.giovanni.fizzbuzz.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.example.giovanni.fizzbuzz.Application;
import org.example.giovanni.fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = Application.class,
					webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzBuzzControllerIntegrationTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void getFizzBuzzStringValidRequest_ResponseIsOK() {
		String expectedResult = "1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco " +
								"14 fizzbuzz 16 17 fizz 19 buzz" +
								FizzBuzz.LINE_SEPARATOR + 
								"fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10";
		
		ResponseEntity<String> response = testRestTemplate.
		getForEntity("/fizzBuzzString?start=1&end=20", String.class);		  
		assertEquals(response.getStatusCode(), HttpStatus.OK);  
		assertEquals(response.getBody(), expectedResult);
	}
	
	@Test
	public void getFizzBuzzStringWithStringParameter_ResponseIsBadRequest() {
		ResponseEntity<String> response = testRestTemplate.
		getForEntity("/fizzBuzzString?start=one&end=two", String.class);		  
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);  
	}

}
