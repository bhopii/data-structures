package org.bhopii.ds.algo;

public class SublistSearch {

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.insert(list1, 10);
		list1.insert(list1, 20);

		LinkedList list2 = new LinkedList();
		list2.insert(list2, 5);
		list2.insert(list2, 10);
		list2.insert(list2, 20);
		
		System.out.println(findList(list1.head, list2.head));

	}

	private static boolean findList(Node first, Node second) {
		if (first == null && second == null) {
			return true;
		}

		if (first == null || (first != null && second == null)) {
			return false;
		}

		Node ptr1 = first;
		Node ptr2 = second;

		while (second != null) {
			ptr2 = second;
			while (ptr1 != null) {
				if (ptr2 == null) {
					return false;
				} else if (ptr1.data == ptr2.data) {
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				} else {
					break;
				}
			}

			if (ptr1 == null) {
				return true;
			}

			ptr1 = first;
			second = second.next;
		}

		return false;
	}

}
