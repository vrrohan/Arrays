/*
 * Segregate array of 0's and 1's. Move all zeros to beginning of array and all ones to end of array.
 */
public class SegregateArraysOfOnesAndZeros {

    /*
     * function to display array elements
     */
    static void displayArray(int[] arr) {
        System.out.print("\nArray elements are : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /*
     * This method will segregate array i.e. it will move all 0's to beginning and
     * all 1's to the end of array.
     * 
     * It will first count no. of 0's and then make 1st n number of array elements
     * as 0
     * Remaining it will make it as 1
     * 
     * tc - O(n) for counting number of 0's + O(n) while iterating over array to
     * fill 0's and 1's = 2 O(n)
     * sc - O(1)
     * 
     * return - segregated array
     */
    static int[] segregateArray(int[] arr) {
        int zeroCount = 0;
        // count total number of 0's
        for (int i = 0; i < arr.length; i++) {
            zeroCount = (arr[i] == 0) ? zeroCount + 1 : zeroCount;
        }

        // fill first n places with 0
        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }

        // fill remaining places with 1
        for (int j = zeroCount; j < arr.length; j++) {
            arr[j] = 1;
        }

        return arr;
    }

    /*
     * This method will make use of 2 pointer approach - left pointer will track 0,
     * while right pointer will track 1
     * 
     * In any case, if any one of them is out of place - we will swap it. Example -
     * (1, ...., 0), here we will swap it
     * 
     * If both of them is 1, then we will decrement the right pointer, since it is
     * in correct place. Exampe - (1, ..., 1)
     * If both of then is 0, then will will decrement the left pointer, since left 0
     * is in correct place. Example - (0, ...., 0)
     * 
     * If left is 0 and right is 1, then it is in correct place.
     * 
     * tc - O(n/2), since we are iterating over array only once
     * sc - O(1)
     */
    static int[] segregateArrayWithTwoPointer(int[] arr) {
        int leftPointer = 0, rightPointer = arr.length - 1;

        while (leftPointer <= rightPointer) {
            if (arr[leftPointer] == 1 && arr[rightPointer] == 1) {
                rightPointer--;
            } else if (arr[leftPointer] == 0 && arr[rightPointer] == 0) {
                leftPointer++;
            } else if (arr[leftPointer] == 0 && arr[rightPointer] == 1) {
                leftPointer++;
                rightPointer--;
            } else {
                // if left is 1 and right is 0, then we will make left=0 and right=1
                arr[leftPointer] = 0;
                arr[rightPointer] = 1;
                leftPointer++;
                rightPointer--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] binaryArray = { 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 };
        int[] segregatedArray = segregateArrayWithTwoPointer(binaryArray);
        displayArray(segregatedArray);
    }
}
