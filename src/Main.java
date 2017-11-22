//import java.util.Arrays;

public class Main {

	public static String cardmatch(int num) {// method to convert cards to
		// A,J,Q,K
		if (num == 1)// 1 represents A
			return "A";
		else if (num == 11)// 11 represents J
			return "J";
		else if (num == 12)// 12 represents Q
			return "Q";
		else if (num == 13)// 13 represents K
			return "K";
		else
			return num + ""; // else just return the card number
	}

	public static double eval(double a, double b, String k) {
		// for evaluating the operations, but this only for the purpose of
		// printing out the steps
		// I repeat this is not the postfixed evaluation
		double c = 0;
		if (k == "+") {
			c = a + b;
			return c;
		} else if (k == "-") {
			c = a - b;
			return c;
		} else if (k == "*") {
			c = a * b;
			return c;
		} else // (k == "/")
		{
			c = a / b;
			return c;
		}
	}

	public static void main(String[] args) {// main method

		PostFixed value = new PostFixed();// importing the postfixed class
		String[] opparray = new String[4];// array to hold the operators
		opparray[0] = "+";// add to operator array
		opparray[1] = "-";// add to operator array
		opparray[2] = "*";// add to operator array
		opparray[3] = "/";// add to operator array

		for (int i1 = 1; i1 <= 13; i1++)// 4 for loops to give us all the
			// possible card combinations
			for (int i2 = i1; i2 <= 13; i2++)
				for (int i3 = i2; i3 <= 13; i3++)
					for (int i4 = i3; i4 <= 13; i4++) {
						int c1 = i1;
						int c2 = i2;
						int c3 = i3;
						int c4 = i4;
						for (String k : opparray)// 3 for loops to give us the
							// possible operators
							for (String k2 : opparray)
								for (String k3 : opparray) {
									// first card order
									// I hard coded the first form of the
									// postfixed notation into the main method:
									// c1 c2 k c3 k2 c4 k3
									// The other print statements are for
									// showing the steps to get to 24.
									if (value.postfixeval(c1 + " " + c2 + " " + k + " " + c3 + " " + k2 + " " + c4 + " "
											+ k3) == 24) {
										System.out.print("cards: " + cardmatch(i1) + cardmatch(i2) + cardmatch(i3)
										+ cardmatch(i4) + " :");
										System.out.print(c1 + k + c2 + "= ");
										System.out.print(eval(c1, c2, k) + ", ");
										System.out.print(eval(c1, c2, k) + k2 + c3 + "= ");
										System.out.print(eval(eval(c1, c2, k), c3, k2) + ", ");
										System.out.print(eval(eval(c1, c2, k), c3, k2) + k3 + c4 + "= ");
										System.out.println(eval(eval(eval(c1, c2, k), c3, k2), c4, k3));
									}

									// 2nd card combos
									// I hard coded the second form of the
									// postfixed notation into the main method:
									// c1 c2 k c3 c4 k2 k3
									// The other print statements are for
									// showing the steps to get to 24.
									if (value.postfixeval(c1 + " " + c2 + " " + k + " " + c3 + " " + c4 + " " + k2 + " "
											+ k3) == 24) {
										System.out.print("cards: " + cardmatch(i1) + cardmatch(i2) + cardmatch(i3)
										+ cardmatch(i4) + " :");
										System.out.print(c1+k+c2+"= ");
										System.out.print(eval(c1,c2,k)+ ", ");
										System.out.print(c3+k2+c4+"= ");
										System.out.print(eval(c3,c4,k2)+ ", ");
										System.out.print(eval(c1,c2,k)+k3+eval(c3,c4,k2)+"= ");
										System.out.println(eval(eval(c1,c2,k),eval(c3,c4,k2),k3));

										//System.out.println(c1 + " " + c2 + " " + k + " " + c3 + " " + c4 + " " + k2
											//	+ " " + k3 + "= 24");
									}

									// 4th card combo
									// I hard coded the fourth form of the
									// postfixed notation into the main method:
									// c1 c2 c3 k c4 k2 k3
									// The other print statements are for
									// showing the steps to get to 24.
									if (value.postfixeval(c1 + " " + c2 + " " + c3 + " " + k + " " + c4 + " " + k2 + " "
											+ k3) == 24) {
										System.out.print("cards: " + cardmatch(i1) + cardmatch(i2) + cardmatch(i3)
										+ cardmatch(i4) + " :");
										System.out.print(c2+k+c3+"= ");
										System.out.print(eval(c2,c3,k)+ ", ");
										System.out.print(eval(c2,c3,k)+k2+c4+ "= ");
										System.out.print(eval(eval(c2,c3,k),c4,k2)+ ", ");
										System.out.print(c1+k3+eval(eval(c2,c3,k),c4,k2)+"= ");
										System.out.println(eval(c1,eval(eval(c2,c3,k),c4,k2),k3));
										
										
										/*System.out.print(c1 + " " + c2 + " " + c3 + " " + k + " " + c4 + " " + k2 + " "
												+ k3 + " = ");
										System.out.println(value.postfixeval(
												c1 + " " + c2 + " " + c3 + " " + k + " " + c4 + " " + k2 + " " + k3));
												*/
									}

									// 3rd card combo
									// I hard coded the third form of the
									// postfixed notation into the main method:
									// c1 c2 c3 k k2 c4 k3
									// The other print statements are for
									// showing the steps to get to 24.
									if (value.postfixeval(c1 + " " + c2 + " " + c3 + " " + k + " " + k2 + " " + c4 + " "
											+ k3) == 24) {
										System.out.print("cards: " + cardmatch(i1) + cardmatch(i2) + cardmatch(i3)
										+ cardmatch(i4) + " :");
										System.out.print(c2+k+c3+"= ");
										System.out.print(eval(c2,c3,k)+ ", ");
										System.out.print(eval(c2,c3,k)+k2+c1+ "= ");
										System.out.print(eval(eval(c2,c3,k),c1,k2)+ ", ");
										System.out.print(c4+k3+eval(eval(c2,c3,k),c1,k2)+"= ");
										System.out.println(eval(c4,eval(eval(c2,c3,k),c1,k2),k3));
										
										/*
										System.out.print(c1 + " " + c2 + " " + c3 + " " + k + " " + k2 + " " + c4 + " "
												+ k3 + " = ");
										System.out.println(value.postfixeval(
												c1 + " " + c2 + " " + c3 + " " + k + " " + k2 + " " + c4 + " " + k3));
												*/

									}
									// 5th card combo
									// I hard coded the fifth form of the
									// postfixed notation into the main method:
									// c1 c2 c3 c4 k k2 k3
									// The other print statements are for
									// showing the steps to get to 24.
									if (value.postfixeval(c1 + " " + c2 + " " + c3 + " " + c4 + " " + k + " " + k2 + " "
											+ k3) == 24) {
										System.out.print("cards: " + cardmatch(i1) + cardmatch(i2) + cardmatch(i3)
										+ cardmatch(i4) + " :");
										System.out.print(c3+k+c4+"= ");
										System.out.print(eval(c3,c4,k)+ ", ");
										System.out.print(c2+k2+eval(c3,c4,k)+"= ");
										System.out.print(eval(c2,eval(c3,c4,k),k2)+", ");
										System.out.print(c1+k3+eval(c2,eval(c3,c4,k),k2)+"= ");
										System.out.println(eval(c1,eval(c2,eval(c3,c4,k),k2),k3));
										
										
										
										/*
										System.out.print(c1 + " " + c2 + " " + c3 + " " + c4 + " " + k + " " + k2 + " "
												+ k3 + " = ");
										System.out.println(value.postfixeval(
												c1 + " " + c2 + " " + c3 + " " + c4 + " " + k + " " + k2 + " " + k3));
									*/
									}
								}
					}
	}
}
