import java.util.Arrays;
public class Main
{
    public static void reverseArray(int[] arr, int n, int i){
        if(i>=n/2){
            return;
        }
        int temp = arr[n-i-1]; // Here n-i-1 gives the pointer to the last element
        arr[n-i-1] = arr[i];
        arr[i] = temp;
        reverseArray(arr, n,i+1);
    }
    
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		reverseArray(arr, arr.length, 0);
		System.out.println(Arrays.toString(arr)); // Output: [8,7,6,5,4,3,2,1]
	}
}
