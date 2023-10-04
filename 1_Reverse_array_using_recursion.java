import java.util.Arrays;
public class Main
{
    // parameters l and r which points to the first and last index of the array
    public static void reverseArray(int[] arr, int l, int r){
      // Base condition to check if all charecters are covered
        if(l>r){
            return;
        }
      //swapping first and last element using l and r pointers
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
        reverseArray(arr, l+1, r-1);
    }
    
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		reverseArray(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));  // Output : [8,7,6,5,4,3,2,1]
	}
}
