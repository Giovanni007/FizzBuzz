package org.example.giovanni.fizzbuzz.controller;

import org.example.giovanni.fizzbuzz.FizzBuzz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {
	
	private FizzBuzz fizzBuzz;

	public FizzBuzzController(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/fizzBuzzString")
	public String getUserDetails(@RequestParam int start, @RequestParam int end) {
		return  fizzBuzz.getFizzBuzzString(start, end);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity handlerSameIllegalArgumentException(IllegalArgumentException e){
	return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

	}
}
