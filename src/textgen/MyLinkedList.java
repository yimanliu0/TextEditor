package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = new LLNode<E>(element);
		if (size == 0) {
			head = node;
			tail = node;
		}
		node.prev = tail;
		tail.next = node;
		tail = node;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E >target = new LLNode<E>(null);
		E result = null;
		target = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				result = target.data;
				break;
			}
			else {
				 target = target.next;
			}
		}
		return result;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> dump = new LLNode<E>(null);
		if (size == 0) {
			head = node;
			tail = node;
		}
		dump = head;
		for (int i = 0; i <= size; i++) {
			if (i == 0 && i == index) {
				node.next = dump;
				head = node;
				break;
			}
			if (i == size && i == index) {
				node.prev = dump;
				tail = node;
				break;
			}
			if (i == index) {
				node.next = dump;
				node.prev = dump.prev;
				dump.prev.next = node;
				dump.prev = node;
				break;
			}
			dump = dump.next;
		}
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = new LLNode<E>(null);
		node = head;
		for (int i = 0; i < size; i++) {
			if (i == 0 && i == index) {
				head = node.next;
				node.next.prev = null;
				node.next = null;
				break;
			}
			if (i == size - 1 && i == index) {
				tail = node.prev;
				node.prev.next = null;
				node.prev = null;
				break;
			}
			if (i == index) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node.next = null;
				node.prev = null;
				break;
			}
			node = node.next;
		}
		size--;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> dump = new LLNode<E>(null);
		dump = head;
		for (int i = 0; i < size; i++) {
			if (i == 0 && i == index) {
				node.next = dump.next;
				dump.next = null;
				head = node;
				break;
			}
			if (i == size - 1 && i == index) {
				node.prev = tail.prev;
				tail.prev = null;
				tail = node;
				break;
			}
			if (i == index) {
				node.next = dump.next;
				node.prev = dump.prev;
				dump.next = null;
				dump.prev = null;
				break;
			}
			else {
				dump = dump.next;
			}
		}
		return dump.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
