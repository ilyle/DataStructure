package edu.coerscnu.basic.queue;

import edu.coerscnu.basic.list.LinkedList.MyLinkedList;

/**
 * 链式队列
 * 
 * @author xujie
 *
 * @param <E>
 */
public class MyQueue<E> {

	private MyLinkedList<E> linkedList;
	
	public MyQueue() {
		linkedList = new MyLinkedList<>();
	}
	
	/**
	 * 入队
	 * @param e
	 * @return
	 */
	public boolean enQueue(E e) {
		return linkedList.add(e);
	}
	
	/**
	 * 出队
	 * 
	 * @return
	 */
	public E deQueue() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("空队列异常");
		return linkedList.removeFirst();
	}
	
	public E element() {
		if (isEmpty())
			throw new IndexOutOfBoundsException("空队列异常");
		return linkedList.get(0);
	}
	
	public boolean clear() {
		return linkedList.clear();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public int size() {
		return linkedList.size();
	}
}
