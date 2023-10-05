class Solution {

    public static void findAllSubsequences(int[] arr,int i, int n,List<List<Integer>> finalList, ArrayList<Integer> ds){
        if(i>n){
            List<Integer> temp = new ArrayList<Integer>();
            for(int element : ds){
                temp.add(element);
            }
            finalList.add(temp);
            return;
        }
        ds.add(arr[i]);
        findAllSubsequences(arr,i+1,n,finalList,ds);
        ds.remove(ds.size()-1);
        findAllSubsequences(arr,i+1,n,finalList,ds);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        findAllSubsequences(nums,0,nums.length-1,finalList,new ArrayList<Integer>());
        return finalList;
    }
}
