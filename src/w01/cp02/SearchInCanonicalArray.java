package w01.cp02;

public class SearchInCanonicalArray {

	static int findMaxInArray(int[] numbers, int l, int r) {
		int middle = (l + r) / 2;

		if (numbers[middle] > numbers[middle - 1] && numbers[middle] > numbers[middle + 1]) {
			return middle;
		} else if (numbers[middle] > numbers[middle - 1] && numbers[middle] < numbers[middle + 1]) {
			middle = findMaxInArray(numbers, middle, r);
		} else if (numbers[middle] < numbers[middle - 1] && numbers[middle] > numbers[middle + 1]) {
			middle = findMaxInArray(numbers, 0, middle);
		}
		return middle;
	}

	static boolean find(int[] numbers, int l, int r, int key) {
		int max = findMaxInArray(numbers, l, r);

		if (numbers[max] < key) {
			return false;
		}

		boolean found = searchOnLeft(numbers, l, max, key);
		if (!found) {
			found = searchOnRight(numbers, max, r, key);
		}

		return found;
	}

	private static boolean searchOnRight(int[] numbers, int l, int r, int key) {
		if (r > l) {

			int middle = (l + r) / 2;

			boolean found = false;
			if (numbers[middle] == key) {
				return true;
			} else if (numbers[middle] > key) {
				found = searchOnRight(numbers, middle + 1, r, key);
			} else {
				found = searchOnRight(numbers, l, middle + 1, key);
			}

			return found;
		}
		return false;
	}

	private static boolean searchOnLeft(int[] numbers, int l, int r, int key) {
		if (r > l) {

			int middle = (l + r) / 2;

			boolean found = false;
			if (numbers[middle] == key) {
				return true;
			} else if (numbers[middle] > key) {
				found = searchOnLeft(numbers, l, middle, key);
			} else {
				found = searchOnLeft(numbers, middle + 1, r, key);
			}
			return found;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 5, 7, 9, 10, 8, 6 };
		System.out.println(findMaxInArray(numbers, 0, numbers.length - 1));
		System.out.println(find(numbers, 0, numbers.length - 1, 8));
	}
}