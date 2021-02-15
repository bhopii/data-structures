package org.bhopii.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseWordsTest {
	
	@Test
	public void test1() {
		Assertions.assertEquals("This is rev sentence", reverseSentence("sentence rev is This"));
	}
	
	@Test
	public void test2() {
		Assertions.assertEquals("Ab", reverseSentence("Ab"));
	}

	private String reverseSentence(String inputString) {
		
		String[] words = inputString.split(" ");
		printStringArr(words);
		return reverseArray(words);
		
	}

	private void printStringArr(String[] words) {
		for(int i = 0 ; i < words.length; i ++) {
			System.out.println(words[i]);
		}
		
	}

	private String reverseArray(String[] words) {
		String revStr = "";
		System.out.println(words.length);
		for(int i = words.length - 1; i >= 0; i--)
		{
			revStr = revStr + words[i] + " ";
		}
		return revStr.trim();
	}
}
