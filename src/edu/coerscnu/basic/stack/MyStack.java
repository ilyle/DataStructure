package edu.coerscnu.basic.stack;

import edu.coerscnu.basic.list.ArrayList.MyArrayList;

public class MyStack<E> {
	private MyArrayList<E> arrayList;

	public MyStack() {
		arrayList = new MyArrayList<>();
	}

	public boolean push(E ele) {
		arrayList.add(ele);
		return false;
	}

	public E pop() {
		int size = size();
		E ele = arrayList.get(size - 1);
		arrayList.remove(size - 1);
		return ele;
	}

	public E peek() {
		return arrayList.get(arrayList.size() - 1);
	}

	public int size() {
		return arrayList.size();
	}

	public boolean isEmpty() {
		return arrayList.isEmpty();
	}
}
