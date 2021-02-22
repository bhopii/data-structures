package org.bhopii.ds.algo;

public class LinkedList {
	Node head;

	public LinkedList insert(LinkedList list, int data) {

		Node newNode = new Node(data);
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = newNode;
		}

		return list;

	}

	// Method to print the LinkedList.
	public void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}
	
	public boolean hasLoop() {
		Node slow, fast;
		if((head == null) || (head.next==null)) {
			return false;
		}
		
		slow = head;
//		ln2 = head.next;
		fast = head.next;
		

		while(true) {
			System.out.println("1. slow node " + slow.data);
			System.out.println("1. fast node " + fast.data);
			if(slow==fast) {
				return true;
			}
			
			if(slow.next == null) {
				return false;
			} else {
				slow = slow.next;
			}
			System.out.println("2. slow node " + slow.data);
			System.out.println("2. fast node " + fast.data);
//			if(slow == fast) {
//				return true;
//			}
			
			if(fast.next == null) {
				return false;
			} else {
				fast = fast.next;
			}
			System.out.println("3. slow node " + slow.data);
			System.out.println("3. fast node " + fast.data);
			
			//This was my answer
			if(slow == fast) {
				return true;
			}
			
			if(fast.next == null) {
				return false;
			} else {
				fast = fast.next;
			}
			System.out.println("4. slow node " + slow.data);
			System.out.println("4. fast node " + fast.data);
			
		}
	}

}
