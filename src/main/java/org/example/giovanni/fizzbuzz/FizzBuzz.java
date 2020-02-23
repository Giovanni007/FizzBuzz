package org.example.giovanni.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FizzBuzz {
	public static final Logger logger = LoggerFactory.getLogger(FizzBuzz.class);

	public static final String MULTIPLE_OF_3_STR = "fizz";
	public static final String MULTIPLE_OF_5_STR = "buzz";
	public static final String MULTIPLE_OF_15_STR = "fizzbuzz";
	public static final String CONTAINS_3_STR = "alfresco";
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public String getFizzBuzzString(int x, int y) {
		Map<String,Integer> reportMap = initializeReportMap();
		
		//Check range 
		if(x<=0 || y <= 0) throw new IllegalArgumentException("Invalid Input");
		int start = Integer.min(x, y);
		int end = Integer.max(x, y);
		
		StringBuilder sb = new StringBuilder();
		
		//Create fizzbuzz string 
		for(int i=start; i<=end; i++) {
			String fizzBuzzWord = getFizzBuzzWord(i);
			sb.append(fizzBuzzWord);
			sb.append(" ");
			
			addToReport(fizzBuzzWord,reportMap);
		}
		
		//Delete the last space
		sb.setLength(sb.length()-1);
		
		sb.append(LINE_SEPARATOR);
		//Add report at the end of the fizzBuzz string
		sb.append(getReportString(reportMap));
		logger.debug(sb.toString());
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
	
	private Map<String,Integer> initializeReportMap() {
		Map<String,Integer> map = new LinkedHashMap<> ();
		map.put(MULTIPLE_OF_3_STR,0);
		map.put(MULTIPLE_OF_5_STR,0);
		map.put(MULTIPLE_OF_15_STR,0);
		map.put(CONTAINS_3_STR,0);
		map.put("integer",0);
		
		return map;

	}
	
	private void addToReport(String word, Map<String,Integer> map) {
        BiFunction<String, Integer, Integer> add = (key, val) -> val + 1; 

		if(map.computeIfPresent(word, add) == null)
			map.compute("integer", add);
	}
	
	String getReportString(Map<String,Integer> map) {
	    return map.entrySet().stream()
	        .map(e -> e.getKey() + ": " + e.getValue())
	        .collect(Collectors.joining(" "));
	}
	
}
