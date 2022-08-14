package recursion;
import java.util.*;

class Subsequences {
    
    static int iterations = 0;
    
    private static void printAllsubsequence(int index, List<Integer> ds, List<Integer> arr, int arrSize){
        iterations++;
        if(index==arrSize){
            System.out.println(ds);
            return;
        }
        ds.add(arr.get(index));
        printAllsubsequence(index+1, ds, arr, arrSize);
        ds.remove(ds.size()-1);
        printAllsubsequence(index+1, ds, arr, arrSize);
    }
    
    private static void subsequenceSum(int index, List<Integer> ds, List<Integer> arr,int arrSize, int sum, int reqSum){
        iterations++;
        if(index==arrSize){
            if(sum==reqSum){
               System.out.println(ds);
            }
            return;
        }
        
        sum=sum+arr.get(index);
        ds.add(arr.get(index));
        subsequenceSum(index+1, ds, arr, arrSize, sum, reqSum);
        
        sum=sum-ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        subsequenceSum(index+1, ds, arr, arrSize, sum, reqSum);
    }
    
    private static boolean checkSubsequenceSum(int index, List<Integer> ds, List<Integer> arr,int arrSize, int sum, int reqSum){
        iterations++;
        if(index==arrSize){
            if(sum==reqSum){
               System.out.println(ds);
               return true;
            }
            return false;
        }
        
        sum=sum+arr.get(index);
        ds.add(arr.get(index));
        if(checkSubsequenceSum(index+1, ds, arr, arrSize, sum, reqSum)==true){
            return true;
        }
        
        sum=sum-ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        if(checkSubsequenceSum(index+1, ds, arr, arrSize, sum, reqSum)==true){
            return true;
        }
        return false;
    }
    
    private static boolean checkSubsequenceSumOptimized(int index, List<Integer> ds, List<Integer> arr,int arrSize, int sum, int reqSum){
        iterations++;
        if(sum>reqSum){
            return false;
        }
        if(index==arrSize){
            if(sum==reqSum){
               System.out.println(ds);
               return true;
            }
            return false;
        }
        
        sum=sum+arr.get(index);
        ds.add(arr.get(index));
        if(checkSubsequenceSumOptimized(index+1, ds, arr, arrSize, sum, reqSum)==true){
            return true;
        }
        
        sum=sum-ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        if(checkSubsequenceSumOptimized(index+1, ds, arr, arrSize, sum, reqSum)==true){
            return true;
        }
        return false;
    }
    
    private static int countNoOfSubsequenceSum(int index, List<Integer> arr,int arrSize, int sum, int reqSum){
        iterations++;
        if(sum>reqSum){
            return 0;
        }
        if(index==arrSize){
            if(sum==reqSum){
               return 1;
            }
            return 0;
        }
        
        sum=sum+arr.get(index);
        int left = countNoOfSubsequenceSum(index+1, arr, arrSize, sum, reqSum);
        
        sum=sum-arr.get(index);
        int right = countNoOfSubsequenceSum(index+1, arr, arrSize, sum, reqSum);
        
        return left+right;
    }
    
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
        al.add(4);
        al.add(5);
		List<Integer> ds = new ArrayList<Integer>();

        System.out.println("Printing All Subsequences");
		printAllsubsequence(0,ds,al,al.size());
        System.out.println("Iterations:- "+String.valueOf(iterations));
        
        iterations = 0;
        System.out.println("Printing All Subsequences whose sum is equal to Req Sum");
        subsequenceSum(0,ds,al,al.size(),0,8);
        System.out.println("Iterations:- "+String.valueOf(iterations));
        
        iterations = 0;
        System.out.println("Checking if any Subsequences having sum is equal to Req Sum");
        System.out.println(checkSubsequenceSum(0,ds,al,al.size(),0,8));
        System.out.println("Iterations:- "+String.valueOf(iterations));
        
        iterations = 0;
        ds.clear();
        System.out.println("Checking if any Subsequences having sum is equal to Req Sum - Optimized");
        System.out.println(checkSubsequenceSumOptimized(0,ds,al,al.size(),0,8));
        System.out.println("Iterations:- "+String.valueOf(iterations));
        
        iterations = 0;
        ds.clear();
        System.out.println("Counting no of Subsequences whose sum is equal to Req Sum - Optimized");
        System.out.println(countNoOfSubsequenceSum(0,al,al.size(),0,8));
        System.out.println("Iterations:- "+String.valueOf(iterations));
        
    }
}
