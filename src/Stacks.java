
public class Stacks {
	public interface Stack<E>{
		int size();
		boolean isEmpty();
		E top();
		void push(E element);
		E pop();
	}

	public class ArrayStack<E> implements Stack <E>{ //My stack method 
		private final Exception IllegalStateException = null;
		
		private E[] Stack; //the elements that go in the stack
		private int top = 0;  //the top element
						// Why was this -1 to start off I changed it to 0
		public ArrayStack(int capacity){ //constructor
			Stack = (E[]) new Object[capacity];	
		}
		public boolean isEmpty(){ //Checks if the stack is empty 
			if(Stack[top] == null)
				return true;
			else return false;
		}

		public E pop(){ //Removes the first value from the stack and returns it 
			if (isEmpty())//empty check
				return null;
			E temp = Stack[top]; //stores the top value 
			Stack[top] = null; 
			top = top - 1; // makes the next value the top one
			return temp; //returns the top value
		}

		public void push(E element){//places an element into the stack
				top = top + 1; //creates a new top
				Stack[top] = element;//inserts the new element in
		}
		
		public E top(){// returns the top element but doesn't remove it
			return Stack[top];
		}
		public int size(){//returns the number of elements in the stack 
			return top;
		}

	}

}
