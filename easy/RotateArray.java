/*
 * Rotate the array by k places - means move the last k elements to the front of array. k>0 && k>length(Array)
 * 
 * Example - [1,2,3,4,5], k=2 ==> first rotation [5,1,2,3,4], 2nd rotation [4,5,1,2,3]
 * 
 * Example - [1,2,3,4,5,7], k=3 ==> after 3 rotations arr = [4,5,7,1,2,3]
 * 
 * Example - [1,2,3,4,5], k=8 ==> after 1 rotation arr=[5,1,2,3,4], after 2nd rotation arr=[4,5,1,2,3]
 *          after 5 rotations arr=[1,2,3,4,5] ==> after 8 rotations arr=[3,4,5,1,2]
 */
public class RotateArray {

    /*
     * This method will take extra temp array and store last k%len(arr) elements to
     * front of tempArray
     * Rest remaining elements from 0 till k%len(arr) elements to back of tempArray.
     * 
     * k%len(arr) because when k==length(arr) ==> after k rotations array became
     * same as 0 rotation
     * example - k=8 arr=[1,2,3,4,5], 8%5=3 ==> after 8 rotations array == array
     * after 3 rotations
     * 
     * tc - O(n) - O(n/k) + O(k-1) ~ O(k) == O(n)
     * sc - O(n)
     */
    static int[] rotateArray(int[] arr, int k) {
        int[] tempArray = new int[arr.length];
        int tempIndex = 0;

        // this will gets us the number of elements we want from the back of array
        int index = k % arr.length;
        // this will get the start index to iterate the last k elements
        int startIndexOfLastKElements = arr.length - index;

        // fill last k elements to front of temp array
        for (int i = startIndexOfLastKElements; i < arr.length; i++) {
            tempArray[tempIndex++] = arr[i];
        }

        // now fill the remaining 0 to k-1 elements of array in remaining temp array
        for (int i = 0; i < startIndexOfLastKElements; i++) {
            tempArray[tempIndex++] = arr[i];
        }
        return tempArray;
    }

    /*
     * This method will reverse the array using 2 pointer
     * 
     * tc - O(n)
     * sc - O(1)
     */
    static int[] reverseArray(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    /*
     * This method will reverse the first k-1 elements.Then it will reverse the last
     * k elements
     * And then it will reverse the whole array.
     * 
     * tc - O(n) - O(n/2) + O(n/2) ~ O(n)
     * sc - O(1)
     */
    static int[] rotateArrayOptimized(int[] arr, int k) {
        if (k <= 0) {
            return arr;
        }
        int pivot = k % arr.length;
        int firstHalf = arr.length - pivot;

        // first reverse the first half elements of array
        arr = reverseArray(arr, 0, firstHalf - 1);

        // now reverse the last pivot or k elements
        arr = reverseArray(arr, firstHalf, arr.length - 1);

        // now reverse the whole array
        arr = reverseArray(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] rotatedArray = rotateArrayOptimized(arr, 10);

        System.out.println();
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}
