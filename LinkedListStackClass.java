
/*
 * Your name: Reed Elliott
 * Description: Program 3 - Stack using Linked lists
 */

import java.util.EmptyStackException;

public class LinkedListStackClass {

	private LinkedListNode head;
	private int size;

	public LinkedListStackClass() {
		this.head = null;
		this.size = 0;
	}

	public char pop() {
		if (this.empty())
			throw new EmptyStackException();
		char returnValue = this.head.value;
		this.head = this.head.next;
		this.size--;
		return returnValue;
	}

	public void push(char element) {
		this.head = new LinkedListNode(element, head);
		this.size++;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	public char peek() {
		if (this.empty())
			throw new EmptyStackException();
		return this.head.value;
	}

	public int size() {
		return this.size;
	}

}
