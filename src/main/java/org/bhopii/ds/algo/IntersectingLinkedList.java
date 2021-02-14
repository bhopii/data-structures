package org.bhopii.ds.algo;

public class IntersectingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.head = new Node(3);
		list1.head.next = new Node(6);
		list1.head.next.next = new Node(9);
		list1.head.next.next.next = new Node(15);
		list1.head.next.next.next.next = new Node(30);
		
		
		list2.head = new Node(10);
		list2.head.next = new Node(15);
		list2.head.next.next = new Node(30);
		printIntersectionNode(list1.head, list2.head);

	}
	
	private static void printIntersectionNode(Node first, Node second) {
		int count1 = getCount(first);
		int count2 = getCount(second);
		System.out.println("count1 " + count1 + ", count2 " + count2);
		int diff=0;
		
		if(count1 > count2) {
			diff = count1 - count2;
			System.out.println(getIntersection(diff, first, second));
		} else {
			diff = count2 - count1;
			System.out.println(getIntersection(diff, second, first));
		}
		
		
	}

	private static int getIntersection(int diff, Node n1, Node n2) {
		Node cur1 = n1;
		Node cur2 = n2;
		for(int i = 0; i < diff; i++) {
			if(cur1.next == null) {
				return -1;
			} 
			cur1 = cur1.next;
		}
		
		while(cur1 != null & cur2 != null) {
			if(cur1.data == cur2.data) {
				return cur1.data;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return -1;
	}

	private static int getCount(Node node) {
		Node current = node;
		int cnt = 0;
		while(current.next != null) {
			cnt++;
			current = current.next;
		}
		return cnt;
	}
}
