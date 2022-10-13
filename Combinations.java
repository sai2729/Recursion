package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	// One can take each number many times
	private static void printAllCombinationsHavingSumEqualsTarget(List<Integer> ls,int size, List<Integer> ds,int index,int target) {
		if(index==size) {
			if(target==0) {
				System.out.println(ds);
			}
			return;
		}
		
		if(ls.get(index)<=target) {
			ds.add(ls.get(index));
			printAllCombinationsHavingSumEqualsTarget(ls,size,ds,index,target-ls.get(index));
			ds.remove(ds.size()-1);
		}
		printAllCombinationsHavingSumEqualsTarget(ls,size,ds,index+1,target);
		
	}
	
	// There should be unique sets of combinations
	private static void printAllUniqueCombinationsHavingSumEqualsTarget(List<Integer> ls,List<List<Integer>> ans,int size, List<Integer> ds,int index,int target) {
		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for(int i=index;i<size;i++) {
			if(i>index && ls.get(i)==ls.get(i-1)) continue;
			if(ls.get(i)>target) break;
			ds.add(ls.get(i));
			printAllUniqueCombinationsHavingSumEqualsTarget(ls, ans, size, ds, i+1, target-ls.get(i));
			ds.remove(ds.size()-1);
		}
		
	}

	public static void main(String[] args) {
		List<Integer> ls = new ArrayList<Integer>();
		List<Integer> ds = new ArrayList<Integer>();
		ls.add(2);
		ls.add(3);
		ls.add(6);
		ls.add(7);
		
		System.out.println("Printing All Combinations whose sum equals to target");
		printAllCombinationsHavingSumEqualsTarget(ls,ls.size(),ds,0,7);
		ls.clear();
		ls.add(1);
		ls.add(1);
		ls.add(1);
		ls.add(2);
		ls.add(2);
		
		// There should not be repetitive sets
		List<List<Integer>> ans = new ArrayList<>();
		// sort list
		ls.sort(null);
		
		System.out.println("Printing All Unique Combinations whose sum equals to target");
		printAllUniqueCombinationsHavingSumEqualsTarget(ls,ans, ls.size(), ds, 0, 4);
		System.out.println(ans);
		
		ls.clear();
		ds.clear();
		
	}

}
