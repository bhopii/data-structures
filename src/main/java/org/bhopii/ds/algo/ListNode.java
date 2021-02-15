package org.bhopii.ds.algo;

public class ListNode {
	private int value;
	ListNode next;
	
	public ListNode(int v) {
		value = v;
		next = null;
	}
	public ListNode(int v, ListNode n) {
		value = v;
		next = n;
	}
	
	public int getValue() {
		return value;
	}
}

