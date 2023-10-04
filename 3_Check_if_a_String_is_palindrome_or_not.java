import java.util.Arrays;
public class Main
{
    public static boolean checkPalindrome(String gstr, int i, int n){
        if(i>=n){
            return true;
        }
        if(gstr.charAt(i)!=gstr.charAt(n)){
            return false;
        }
        return checkPalindrome(gstr,i+1,n-1);
    }
    
	public static void main(String[] args) {
		String gstr = "madam";
		System.out.println(checkPalindrome(gstr,0,gstr.length()-1));
	}
}
