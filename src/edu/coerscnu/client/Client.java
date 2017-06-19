package edu.coerscnu.client;

import edu.coerscnu.basic.Iterator;
import edu.coerscnu.basic.list.LinkedList.MyLinkedList;
import edu.coerscnu.basic.stack.MyStack;

public class Client {

	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<>();
		for (int i = 0; i < 6; i++) {
			myStack.push("a" + i);
		}
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}
}
