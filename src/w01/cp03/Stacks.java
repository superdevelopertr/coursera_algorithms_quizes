package w01.cp03;

public class Stacks<T> {

	private T[] data;
	private int index;
	private int size;
	
	public Stacks(int size) {
		this.size = size;
		data = (T[]) new Object[size];
	}

	public void push(T t) {
		if(index==(size)) {
			this.size = size*2;
			T[] temp = (T[]) new Object[size];
			copy(data,temp);
			data = temp;
		}
		data[index++] = t;
	}

	private void copy(T[] data2, T[] temp) {
		int i=0;
		for (T t:data2) {
			temp[i++] = t;
		}
	}

	public T pop() {
		int prev = index;
		T t = data[--index];
		data[prev] = null;
		return t;
	}
	
	public T top() {
		return data[index-1];
	}
	
	public int size() {
		return index;
	}

	public static void main(String[] args) {
		Stacks<Integer> s = new Stacks<Integer>(2);
		s.push(20);
		s.push(30);
		s.push(50);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}