package org.example.giovanni.fizzbuzz;


public class FizzBuzz {
	static final String MULTIPLE_OF_3_STR = "fizz";
	static final String MULTIPLE_OF_5_STR = "buzz";
	static final String MULTIPLE_OF_15_STR = "fizzbuzz";
	static final String CONTAINS_3_STR = "alfresco";


	public String getFizzBuzzString(int x, int y) {
		
		//Check range 
		if(x<=0 || y <= 0) throw new IllegalArgumentException();
		int start = Integer.min(x, y);
		int end = Integer.max(x, y);
		
		StringBuilder sb = new StringBuilder();
		
		//Create fizzbuzz string 
		for(int i=start; i<=end; i++) {
			sb.append(getFizzBuzzWord(i));
			sb.append(" ");
		}
		
		//Delete the last space
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	private boolean isMultiple(int input, int number) {
		return input%number == 0;
	}
	
	public String getFizzBuzzWord(int num) {
		
		if(containsDigit(num,3)) return CONTAINS_3_STR;
		
		if(isMultiple(num,15)) return MULTIPLE_OF_15_STR;
		if(isMultiple(num,5)) return MULTIPLE_OF_5_STR;
		if(isMultiple(num,3)) return MULTIPLE_OF_3_STR;
		return String.valueOf(num);
	}
	
	private boolean containsDigit(int num, int digit) {
		int currentNumber = num;
		while (currentNumber > 0 ) {
		    if (currentNumber % 10 == digit) return true;
		    currentNumber = currentNumber / 10;
		}
		return false;
	}
	
}
