package recursion;

import java.util.*;

class printing_all_subsequences {

	private static void subsequence(int index, List<Integer> arr, List<Integer> tempList, int arrSize) {
		if (index == arrSize) {
			System.out.println(tempList);
			return;
		}
		tempList.add(arr.get(index));
		subsequence(index + 1, arr, tempList, arrSize);
		tempList.remove(tempList.size() - 1);
		subsequence(index + 1, arr, tempList, arrSize);
	}

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		List<Integer> temp = new ArrayList<>();
		subsequence(0, al, temp, 5);
	}
}
