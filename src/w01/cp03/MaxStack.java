package w01.cp03;

import java.util.Stack;

public class MaxStack {

	private Stack<Integer> valueStack = new Stack<>();
	private Stack<Integer> maxStack = new Stack<>();

	public void push(Integer item) {
		valueStack.push(item);

		if (!maxStack.isEmpty()) {
			Integer max = maxStack.peek();
			if (item > max) {
				maxStack.push(item);
			} else {
				maxStack.push(max);
			}
		} else {
			maxStack.push(item);
		}
	}
	
	public Integer pop() {
		Integer value = valueStack.pop();
		maxStack.pop();
		return value;
	}
	
	public Integer max() {
		return maxStack.peek();
	}

	public static void main(String[] args) {
		MaxStack s = new MaxStack();
		s.push(4);
		s.push(3);
		s.push(6);
		s.push(1);
		System.out.println(s.max());
		s.pop();
		System.out.println(s.max());
		
		s.pop();
		s.pop();
		System.out.println(s.max());
	}
}