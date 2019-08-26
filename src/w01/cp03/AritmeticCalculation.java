package w01.cp03;

import java.util.Stack;

public class AritmeticCalculation {

	public static int calc(String expression) {
		Stack<Integer> vs = new Stack<Integer>();
		Stack<Character> ss = new Stack<Character>();
		
		for (Character c : expression.toCharArray()) {
			if (c.equals('(')) {
				continue;
			} else if (c.equals(')')) {
				if (vs.size() > 1) {
					int result = 0;
					int n1 = vs.pop();
					int n2 = vs.pop();

					switch (ss.pop()) {
					case '+':
						result = n1 + n2;
						break;
					case '*':
						result = n1 * n2;
						break;
					case '-':
						result = n1 - n2;
						break;
					case '/':
						result = n1 / n2;
					}

					vs.push(result);
				}
			} else if (c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
				ss.push(c);
			} else {
				vs.push(Character.getNumericValue(c));
			}
		}

		return vs.peek();
	}
	
	public static void main(String[] args) {
		System.out.println(calc("((3*2)+((5*7)*2))"));
	}
}