package prog5;
/*
 * Your name: Reed Elliott
 * Description: Program 5 - Driver class
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Program5 {

	public static void main(String[] args) throws IOException {
		FileWriter output = new FileWriter("Program5.out");
		Scanner input = new Scanner(new File("Program3.txt"));
		int counter = 0;

		while (input.hasNextLine()) {
			counter++;
			String line = input.nextLine();
			System.out.println("Processing line: " + line);
			output.append(line);
			output.append("\t->\t");
			output.append(InfixToPostfix(line));
			output.append(String.valueOf('\n'));
			output.flush();
		}

		output.close();
		input.close();

		System.out.println("Processed " + counter + " lines and stored them in Program5.out");
	}

	public static boolean greaterPrecedence(char newChar, char oldChar) {
		return (newChar == '*' || newChar == '/' || newChar == '%') &&
				(oldChar == '+' || oldChar == '-' || oldChar == '–');
	}

	public static String InfixToPostfix(String s) {
		Stack<Character> opStack = new Stack<>();
		String resultString = "";
		boolean stackHasParen = false;

		// scan infix expression from left to right
		for (char c : s.toCharArray()) {
			// if c is a digit or a period or a space
			// we add it to the result
			if ((c >= '0' && c <= '9') || c == '.' || c == ' ') {
				resultString += c;
			}
			// if c is a math operation
			else if (c == '+' || c == '-' || c == '–' || c == '*' || c == '/' || c == '%') {
				if (opStack.empty() ||
						stackHasParen ||
						greaterPrecedence(c, opStack.peek())) {
					opStack.push(c);
				}
				else {
					while (!opStack.empty() &&
							!(opStack.peek() == '(') &&
							!greaterPrecedence(c, opStack.peek())) {
						resultString += " " + opStack.pop();
					}
					opStack.push(c);
				}
			}
			// if c is an open parenthesis
			else if (c == '(') {
				stackHasParen = true;
				opStack.push('(');
			}
			// if c is a close parenthesis
			else if (c == ')') {
				stackHasParen = false;
				while (!opStack.empty()) {
					char next = opStack.pop();
					if (next == '(')
						break;
					resultString += " " + next;
				}
			}
			// if c is invalid
			else {
				return "invalid character";
			}
		}

		// catch unmatched parenthesis
		if (stackHasParen)
			return "unmatched parens";

		// pop and output from the stack until it's empty
		while (!opStack.empty()) {
			resultString += " " + opStack.pop();
		}

		return resultString.replace("  ", " ");
	}

}
