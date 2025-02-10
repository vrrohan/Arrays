/*
 * In an array of 1 to n.. there is one missing number. Return the missing number from the array
 * 
 * Example - [1,3,5,6,2] ==> returns 4
 * 
 * Example - [1,2,3,4,5,6,7,9] ==> returns 9
 */

import java.util.Arrays;

public class FindMissingNumber {

    /*
     * This method will make use of - n*(n+1)/2
     * 
     * x = first calculate total sum of first n natural numbers
     * y = then calculate total sum of all elements of array
     * 
     * return x-y;
     * 
     * tc - O(n)
     * sc - O(1)
     */
    static int findMissingNumber(int[] arr) {
        // sum of first n natural numbers is - n(n+1)/2

        // we will first calculate the sum of all numbers in an array
        int arraySum = Arrays.stream(arr).sum();

        // sum of first arr.length+1 elements
        int elements = arr.length + 1;

        int sumOfFirstNElements = Math.floorDiv(elements * (elements + 1), 2);
        return Math.subtractExact(sumOfFirstNElements, arraySum);
    }

    /*
     * This method will create a temp Array [size +1 of current array]. This temp
     * array will be initialized to all 0.
     * 
     * we will store each element index - if 4 comes, we will make tempArray[3]=1 as
     * visited. Since array starts with 0 index.
     * if 7 comes - tempArray[6]=1
     * 
     * Later we will iterate over temp array and see which index is 0. return that -
     * index+1 as missing element
     * 
     * tc - O(n) , for iterating over array
     * sc - O(n) , for extra temp array
     */
    static int findMissingNumberUsingTempArray(int[] arr) {
        int[] tempArray = new int[arr.length + 1];
        int missingNumber = -1;

        // fill each tempArray[element]=1 as visited
        for (int i = 0; i < arr.length; i++) {
            tempArray[arr[i] - 1] = 1;
        }

        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == 0) {
                missingNumber = i + 1;
                break;
            }
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 4, 7 };
        System.out.println("missing number is : " + findMissingNumberUsingTempArray(arr));
    }
}
