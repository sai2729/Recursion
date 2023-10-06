class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        combinationSumHelper(0,candidates.length-1,candidates,0,target,ds,finalList);
        return finalList;
    }

    public void combinationSumHelper(int i, int n, int[] candidates, int sum, int target, List<Integer> ds, List<List<Integer>> finalList) {
        if(sum>target){
            return;
        }
        if(i>n){
            if(sum==target){
                List<Integer> tmp = new ArrayList<Integer>();
                for(int ele: ds){
                    tmp.add(ele);
                }
                finalList.add(tmp);
            }
            return;
        }
        sum=sum+candidates[i];
        ds.add(candidates[i]);
        combinationSumHelper(i,n,candidates,sum,target,ds,finalList);
        sum=sum-candidates[i];
        ds.remove(ds.size()-1);
        combinationSumHelper(i+1,n,candidates,sum,target,ds,finalList);
    }
}
