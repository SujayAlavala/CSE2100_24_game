
import java.util.Stack;

public class PostFixed {

	public double postfixeval(String string)
	{
		//initial stack that runs through the string
		Stack<String> stack = new Stack<String>();
		//second stack that will store two numbers, these will be evaluated.
		//when the string hits an operator, pops the two numbers out of the second stack
		//and evaluates with the operation and pushes it back into the stack
		Stack<String> stack2 = new Stack<String>();

		//Creates an array string and splits each number or operator into the stack. 
		//splits depending on if there is a space between the numbers or not
		String[] arraystring = string.split(" ");
		for(int k=arraystring.length-1; k >= 0; k-- )
			stack.push(arraystring[k]);

		//Keep running until the stack is empty. 
		while(!stack.isEmpty())
		{
			String nextvalue = stack.pop();//variable to store stack.pop() bc i use it a lot
			if(nextvalue.equals("+"))//if the next value is + do this
			{
				double a = Double.parseDouble(stack2.pop());//pop the first number out
				double b = Double.parseDouble(stack2.pop());//pop the second number out
				double c = a + b;//add them together 
				stack2.push(Double.toString(c)); //add it to the stack
			}
			else if(nextvalue.equals("-") || nextvalue.equals(" - "))// if the next value in the stack is - do this
			{
				double a = Double.parseDouble(stack2.pop());//pop the first number out
				double b = Double.parseDouble(stack2.pop());//pop the second number out
				double c = b - a; //evaluate with the operator 
				stack2.push(Double.toString(c));//add it to the stack
			}
			else if(nextvalue.equals("/"))// if the next value in the stack is / do this
			{
				double a = Double.parseDouble(stack2.pop());//pop the first number out
				double b = Double.parseDouble(stack2.pop());//pop the second number out
				if(a == 0){//undefined case
					double c1 = 0;
					stack2.push(Double.toString(c1));//add it to the stack
				}
				else{
					double c = b / a;//evaluate with the operator 
					stack2.push(Double.toString(c));//add it to the stack
				}
			}
			else if(nextvalue.equals("*"))// if the next value in the stack is * do this
			{
				double a = Double.parseDouble(stack2.pop());//pop the first number out
				double b = Double.parseDouble(stack2.pop());//pop the second number out
				double c = a * b;//evaluate with the operator 
				stack2.push(Double.toString(c));//add it to the stack
			}
			else
			{
				stack2.push(nextvalue);//push the numbers into stack2
			}
		}

		//returns the final total of the cards to check to see if it equals to 24
		return Double.parseDouble(stack2.pop());
	}
}
