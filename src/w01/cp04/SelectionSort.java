package w01.cp04;

public class SelectionSort<T extends Comparable<T>> {

	public  void sort(T[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int minIndex = i;
			T min = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (min.compareTo(numbers[j])==1) {
					min = numbers[j];
					minIndex = j;
				}
			}

			if (minIndex != i) {
				replace(numbers, i, minIndex);
			}
		}
	}

	private  void replace(Comparable<T>[] numbers, int i, int j) {
		Comparable<T> temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;

	}

	public  static void main(String[] args) {
		
		Integer[] numbers = { 3, 5, 7, 9, 12, 34, 0, 4, 6 };
		
		SelectionSort<Integer> sorter = new SelectionSort<>();
		sorter.sort(numbers);

		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}
}