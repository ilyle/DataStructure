package edu.coerscnu.basic.list.LinkedList;

import edu.coerscnu.basic.Iterator;
import edu.coerscnu.basic.list.MyList;

public class MyLinkedList<E> implements MyList<E> {

	// 链表大小
	private int size;
	// 头节点
	private Node<E> firstNode;
	// 尾节点
	private Node<E> lastNode;

	private static class Node<E> {

		private Node<E> prev; // 前置节点

		private Node<E> next; // 后置节点

		private E ele; // 节点数据

		public Node(E ele, Node<E> prev, Node<E> next) {
			this.ele = ele;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
	}

	
	@Override
	public boolean add(E e) {
		if (firstNode == null) {
			firstNode = new Node<E>(e, null, null);
			lastNode = firstNode;
		} else {
			Node<E> node = new Node<E>(e,lastNode,null);
			lastNode.next = node;
			lastNode = node;
		}
		size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		Node<E> node = getNode(index);
		if (node == firstNode) {
			return addFirst(e);
		}
		return addBefore(node, e);
	}

	@Override
	public E set(int index, E e) {
		Node<E> node = getNode(index);
		E old = node.ele;
		node.ele = e;
		return old;
	}

	@Override
	public E get(int index) {
		return getNode(index).ele;
	}

	@Override
	public E remove(int index) {
		Node<E> node = getNode(index);
		if (node == firstNode) {
			return removeFirst();
		} else if (node == lastNode) {
			return removeLast();
		}
		return remove(node);
	}

	public boolean addFirst(E e) {
		Node<E> node = new Node<E>(e, null, firstNode);
		firstNode.prev = node;
		firstNode = node;
		size++;
		return true;
	}
	
	public E removeFirst() {
		if (firstNode == null)
			throw new IllegalAccessError("头节点为空");
		E ret = firstNode.ele;
		firstNode = firstNode.next;
		size--;
		return ret;
	}
	
	public E removeLast() {
		E ret = lastNode.ele;
		lastNode = lastNode.prev;
		size--;
		return ret;
	}
	
	/**
	 * 在指定节点前加入节点
	 * 
	 * @param node
	 * @param e
	 */
	private boolean addBefore(Node<E> node, E e) {
		Node<E> newNode = new Node<E>(e, node.prev, node);
		newNode.prev.next = newNode;
		node.prev = newNode;
		size++;
		return true;
	}

	private E remove(Node<E> node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
		return node.ele;
	}

	/**
	 * 获取指定位置的节点
	 * 
	 * @param index
	 * @return
	 */
	private Node<E> getNode(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<E> node;
		if (index < size / 2) {
			node = firstNode;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
		} else {
			node = lastNode;
			for (int i = size - 1; i > index; i--) {
				node = node.prev;
			}
		}
		return node;
	}

	@Override
	public boolean clear() {
		firstNode = new Node<E>(null, null, null);
		lastNode = new Node<E>(null, firstNode, null);
		firstNode.next = lastNode;
		size = 0;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<E> {

		private Node<E> current = firstNode;

		@Override
		public boolean hasNext() {
			return current != lastNode.next;
		}

		@Override
		public Object next() {
			E ele = current.ele;
			current = current.next;
			return ele;
		}

	}
}
