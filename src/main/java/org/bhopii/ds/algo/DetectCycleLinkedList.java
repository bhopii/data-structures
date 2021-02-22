package org.bhopii.ds.algo;

public class DetectCycleLinkedList {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.head = new Node(3);
		list1.head.next = new Node(6);
		Node cycleNode = new Node(9);
		list1.head.next.next = cycleNode;
		list1.head.next.next.next = new Node(15);
		list1.head.next.next.next.next = new Node(30);
		list1.head.next.next.next.next.next = cycleNode;
		
		
		list2.head = new Node(3);
		list2.head.next = new Node(6);
		list2.head.next.next = new Node(9);
		list2.head.next.next.next = new Node(15);
		list2.head.next.next.next.next = new Node(30);
		list2.head.next.next.next.next.next = new Node(23);
		
//		list2.printList(list2);
		System.out.println(" ");
//		System.out.println(list1.hasLoop());
		System.out.println(list2.hasLoop());
	}
}
