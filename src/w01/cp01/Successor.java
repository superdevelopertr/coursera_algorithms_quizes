package w01.cp01;

public class Successor {
	private int[] numbers;
	private int[] sizes;
	private int[] actual;

	public Successor(int N) {
		numbers = new int[N];
		sizes= new int[N];
		actual= new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i;
			sizes[i] = 1;
			actual[i]=i;
		}
	}

	public void join(int i, int j) {
		int ri = root(i);
		int rj = root(j);

		if (ri != rj) {
			if (sizes[ri] > sizes[rj]) {
				numbers[rj] = numbers[ri];
				sizes[ri]+=sizes[rj];
				actual[ri]=rj;
			} else {
				numbers[ri] = numbers[rj];
				sizes[rj]+=sizes[ri];
			}
		}
	}
	
	public boolean isConnected(int i, int j) {
		int ri = root(i);
		int rj = root(j);
		return ri==rj;
	}

	private int root(int i) {
		int ri = numbers[i];
		while (ri != i) {
			i= ri;
			ri = numbers[i];
		}
		return ri;
	}

	public void remove(int i) {
		join(i,i+1);
	}
	
	public int successor(int i) {
		return actual[root(i+1)];
	}


	public static void main(String[] args) {
		Successor successor = new Successor(10);
		successor.remove(4);
		System.out.println(successor.successor(4));
		successor.remove(5);
		System.out.println(successor.successor(5));
	}


}