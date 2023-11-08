
/*
 * Your name: Reed Elliott
 * Description: Program 3 - Stack using Array
 */

import java.util.EmptyStackException;

public class ArrayStackClass {

	private final char[] elements;
	private int top;

	public ArrayStackClass(int maxElements) {
		if (maxElements <= 0)
			throw new IllegalArgumentException("maxElements <= 0");
		this.elements = new char[maxElements];
		this.top = 0;
	}

	public char pop() {
		if (this.top <= 0)
			throw new EmptyStackException();
		this.top--;
		return this.elements[this.top];
	}

	public void push(char element) {
		if (this.top == elements.length)
			throw new StackOverflowError();
		this.elements[this.top] = element;
		this.top++;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	public char peek() {
		if (this.top <= 0)
			throw new EmptyStackException();
		return this.elements[this.top - 1];
	}

	public int size() {
		return this.top;
	}

}
