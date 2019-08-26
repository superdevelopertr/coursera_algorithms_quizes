package w01.cp04;

public class InsertionSort {

	public static void sort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			int j = i;
			while (j > 0) {
				if (numbers[j] < numbers[j - 1]) {
					replace(numbers, j, j - 1);
				} else {
					break;
				}
				j--;
			}
		}
	}

	private static void replace(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;

	}

	public static void main(String[] args) {
		int[] numbers = { 3, 5, 7, 9, 12, 34, 0, 4, 6 };
		sort(numbers);

		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}

}