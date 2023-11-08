package prog7;

/*
Author: Reed Elliott
Purpose: Program 7 Main
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

public class Program7 {

	private static final double BILLION = 1_000_000_000.0;

	private static void readIntegers(String fileName, int[] listA, int[] listB, int[] listC, ArrayList<Integer> listD) {
		try {

			if (listA.length != listB.length || listA.length != listC.length) {
				throw new IllegalArgumentException();
			}

			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

			// by this point we've established the lists are
			// the same length, so we can do this
			for (int i = 0 ; i < listA.length; i++) {
				int next = Integer.parseInt(bufferedReader.readLine());
				listA[i] = next;
				listB[i] = next;
				listC[i] = next;
				listD.add(next);
			}

			bufferedReader.close();
		} catch (NumberFormatException e) {
			System.out.println("Bad data in " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file " + fileName);
		} catch (IOException e) {
			System.out.println("Unable to close BufferedReader");
		} catch (IllegalArgumentException e) {
			System.out.println("List size mismatch");
		}
	}

	private static void readStrings(String fileName, String[] listA, String[] listB, String[] listC, ArrayList<String> listD) {
		try {

			if (listA.length != listB.length || listA.length != listC.length) {
				throw new IllegalArgumentException();
			}

			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

			// by this point we've established the lists are
			// the same length, so we can do this
			for (int i = 0 ; i < listA.length; i++) {
				String next = bufferedReader.readLine();
				listA[i] = next;
				listB[i] = next;
				listC[i] = next;
				listD.add(next);
			}

			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate file " + fileName);
		} catch (IOException e) {
			System.out.println("Unable to close BufferedReader");
		} catch (IllegalArgumentException e) {
			System.out.println("List size mismatch");
		}
	}

	private static void integerBubbleSort(int[] list) {
		int temp;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[i]) {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}

	// as given by 12.3 Selection & Insertion Sort
	private static void integerSelectionSort(int[] list) {
		int temp;
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[min])
					min = j;
			}
			if (min != i) {
				temp = list[min];
				list[min] = list[i];
				list[i] = temp;
			}
		}
	}

	private static void integerInsertionSort(int[] list) {
		// for each element after the first
		for (int i = 1; i < list.length; i++) {
			// store current element
			int temp = list[i];
			// setup
			int j = i;
			// find correct spot for element
			while (j > 0 && temp < list[j - 1])
				j--;
			// move everything above it up
			for (int k = i; k > j; k--)
				list[k] = list[k - 1];
			// put current element where it belongs
			list[j] = temp;
		}
	}

	private static void stringBubbleSort(String[] list) {
		String temp;
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				// list[j] < list[i]
				if (list[j].compareTo(list[i]) < 0) {
					temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}

	private static void stringSelectionSort(String[] list) {
		String temp;
		for (int i = 0; i < list.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j].compareTo(list[min]) < 0)
					min = j;
			}
			if (min != i) {
				temp = list[min];
				list[min] = list[i];
				list[i] = temp;
			}
		}
	}

	private static void stringInsertionSort(String[] list) {
		// for each element after the first
		for (int i = 1; i < list.length; i++) {
			// store current element
			String temp = list[i];
			// setup
			int j = i;
			// find correct spot for element
			while (j > 0 && temp.compareTo(list[j - 1]) < 0)
				j--;
			// move everything above it up
			for (int k = i; k > j; k--)
				list[k] = list[k - 1];
			// put current element where it belongs
			list[j] = temp;
		}
	}

	public static void main(String[] args) {
		long start, end;
		double seconds;

		int[] integerBubbleArray = new int[20_000];
		int[] integerSelectionArray = new int[20_000];
		int[] integerInsertionArray = new int[20_000];
		ArrayList<Integer> integerArrayList = new ArrayList<>(20_000);

		String[] stringBubbleArray = new String[10_000];
		String[] stringSelectionArray = new String[10_000];
		String[] stringInsertionArray = new String[10_000];
		ArrayList<String> stringArrayList = new ArrayList<>(10_000);

		readIntegers("NumbersInFile.txt", integerBubbleArray, integerSelectionArray, integerInsertionArray, integerArrayList);
		readStrings("StringsInFile.txt", stringBubbleArray, stringSelectionArray, stringInsertionArray, stringArrayList);

		start = System.nanoTime();
		integerBubbleSort(integerBubbleArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("20,000 Integer Bubble Sort: " + seconds + " s");

		start = System.nanoTime();
		integerSelectionSort(integerSelectionArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("20,000 Integer Selection Sort: " + seconds + " s");

		start = System.nanoTime();
		integerInsertionSort(integerInsertionArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("20,000 Integer Insertion Sort: " + seconds + " s");

		// intellij told me to do this, I started with a new Comparator<Integer>
		// and then (o1, o2) -> o1 - o2 then this
		start = System.nanoTime();
		integerArrayList.sort(Comparator.comparingInt(o -> o));
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("20,000 Integer System Sort: " + seconds + " s");

		// Strings

		start = System.nanoTime();
		stringBubbleSort(stringBubbleArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("10,000 String Bubble Sort: " + seconds + " s");

		start = System.nanoTime();
		stringSelectionSort(stringSelectionArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("10,000 String Selection Sort: " + seconds + " s");

		start = System.nanoTime();
		stringInsertionSort(stringInsertionArray);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("10,000 String Insertion Sort: " + seconds + " s");

		start = System.nanoTime();
		// Intellij told me to do this, I started with a new Comparator<String>
		// and then (o1, o2) -> o1.compareTo(o2) then this
		stringArrayList.sort(String::compareTo);
		end = System.nanoTime();
		seconds = (end - start) / BILLION;
		System.out.println("10,000 String System Sort: " + seconds + " s");

	}

}
