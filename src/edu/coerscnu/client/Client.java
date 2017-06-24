package edu.coerscnu.client;

import edu.coerscnu.basic.Iterator;
import edu.coerscnu.basic.list.LinkedList.MyLinkedList;

public class Client {

	public static void main(String[] args) {
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		for (int i = 0; i < 6; i++) {
			linkedList.add(i);
		}
		linkedList.add(3, 666);
		linkedList.remove(linkedList.size() - 1);
		Iterator<Integer> it = linkedList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("first = " + linkedList.get(0));
	}
}
