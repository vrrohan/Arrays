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
     * tc - O(n) - O(k/2) + O(k-1) ~ O(k) == O(n)
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] rotatedArray = rotateArray(arr, 12);

        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
    }
}
