/*
 * check if array is sorted or not either in ascending, increasing or non-decreasing order like (1,2,2,2,2,2,2)
 */
public class CheckIfArraySorted {

    /*
     * tc - O(n), since we are traversing only once
     * sc - O(1)
     * 
     * we will check if current_element <= next_element, then they are in-place
     * but if current_element > next_element, then array is not sorted
     */
    static boolean isArraySorted(int[] arr) {
        boolean isArraySorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isArraySorted = false;
                break;
            }
        }
        return isArraySorted;
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 2, 3, 7, 5 };
        // int[] arr = { 1, 1, 1, 2, 2, 2, 2, 2, 2 };
        // int[] arr = { 1 };
        // int[] arr = { 9, 8, 7, 6, 5, 4, 3 };
        int[] arr = { -4, -3, -1, 0, 1, 3, 4 };
        System.out.println("is array sorted : " + isArraySorted(arr));
    }
}
