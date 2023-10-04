class Solution {

    public boolean checkPalindrome(String s, int l, int r){
        if(l>=r){
            return true;
        }
        if(s.charAt(l)!=s.charAt(r)){
            return false;
        }
        return checkPalindrome(s,l+1,r-1);
    }

    public boolean isPalindrome(String s) {
        String sm = s.toLowerCase().replaceAll("[^a-z0-9]","");
        System.out.println(sm);
        return checkPalindrome(sm,0,sm.length()-1);
    }
}
