package org.bhopii.ds.algo;

public class List {

	private ListNode head;
	public List() {
		head = null;
	}
	public List(ListNode ln) {
		head = ln;
	}
	
	public boolean hasLoop() {
		ListNode ln1, ln2;
		if((head == null) || (head.next==null)) {
			return false;
		}
		
		ln1 = head;
		ln2 = head.next;
		
		while(true) {
			if(ln1==ln2) {
				return true;
			}
			if(ln1.next == null) {
				return false;
			} else {
				ln1 = ln1.next;
			}
			
			if(ln1 == ln2) {
				return true;
			}
			if(ln2.next == null) {
				return false;
			} else {
				ln2 = ln2.next;
			}
			
			//This was my answer
			if(ln1 == ln2) {
				return true;
			}
			
			if(ln2.next == null) {
				return false;
			} else {
				ln2 = ln2.next;
			}
			
		}
	}
}
