package org.example.giovanni.fizzbuzz;


public class FizzBuzz {
	private final String MULTIPLE_OF_3_STR = "fizz";
	private final String MULTIPLE_OF_5_STR = "buzz";
	private final String MULTIPLE_OF_15_STR = "fizzbuzz";


	public String getFizzBuzzString(int x, int y) {
		
		if(x<=0 || y <= 0) throw new IllegalArgumentException();
		
		int start = Integer.min(x, y);
		int end = Integer.max(x, y);
		StringBuilder sb = new StringBuilder();
	
		for(int i=start; i<=end; i++) {
			if(isMultiple(i,15)) sb.append(MULTIPLE_OF_15_STR);
			else if(isMultiple(i,5)) sb.append(MULTIPLE_OF_5_STR);
			else if(isMultiple(i,3)) sb.append(MULTIPLE_OF_3_STR);
			else sb.append(i);
			sb.append(" ");
		}
		
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	private boolean isMultiple(int input, int number) {
		return input%number == 0;
	}
	
}
