package org.bhopii.ds.algo;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {

	public static void main(String[] args) {
		Map<Key, String> testMap = new HashMap<>();
		testMap.put(new Key("abc"), "ABC");
		testMap.put(new Key("def"), "DEF");
		System.out.println(testMap.get(new Key("abc")));
		
	}
	
	private static class Key {
		String key;
		Key(String key) {
			this.key = key;
		}
	}
}
