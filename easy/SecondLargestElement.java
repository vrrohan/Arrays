import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SecondLargestElement {

    /*
     * this method will first find the first largest and then 2nd largest element
     * over two iterations.
     * First iteration will find out the maximum element
     * Second iteration will find out the 2nd maximum element
     * tc - 2 O(n) - since we are iterating two times over an array
     * sc - O(1)
     */
    static int getSecondLargestElement(int[] arr) {
        // initialize with minimum element - check if array contains negative numbers
        // also
        // if array contains negative - initialize with largest negative number -
        // Integer.MIN_VALUE
        int secondLargest = Integer.MIN_VALUE;
        int largest = -1;

        // loop to find the largest element
        for (int i = 0; i < arr.length; i++) {
            largest = (arr[i] > largest) ? arr[i] : largest;
        }

        // 2nd time loop - to check 2nd largest element by comparing it will largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    /*
     * In a single iteration - we will find 2nd largest element
     * use 2 variables - max & secMax, on each iteration compare current value to
     * max and secMax.
     * 
     * if --> currentValue > max - it means it is the maximum value, it will never
     * be secMax. But then max becomes secMax value.
     * else if --> currentValue > secMax && currentValue < max, then secMax will be
     * updated. Because current value is between both max and secMax, so only secMax
     * needs to be updated.
     * 
     * Example - max=8, secMax=6, currentElement=7. Hence, now - max=8, secMax=7
     * 
     * tc - O(n), because we are iterating only once
     * sc - O(1)
     */
    static int secondLargestElementOptimized(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secLargest && arr[i] < largest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }

    /*
     * this method will make use of two pointer approach to find 2nd largest element
     * it is better than 2 variables approach and takes less time ~1/2 of time of 2
     * variables approach.
     * 
     * We will create a right and left pointer. First we will perform 2 variables
     * approach on left pointer.
     * After that we will perform 2 variables approach to right pointer.
     * 
     * tc - O(n/2)
     * sc - O(1)
     */
    static int getSecondLargestElementTwoPointer(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int max = Math.min(arr[0], arr[arr.length - 1]);
        int secMax = Math.max(arr[0], arr[arr.length - 1]);

        if (arr.length == 2) {
            return secMax;
        }

        // max=-1, secMax=-1;

        // [11,33,77,88,99,22,44]
        // left=11 right=44
        // --> left comp - max=11, smax=-1
        // --> right comp - max=44, smax=11

        // left=33, right=22
        // -->left comp = max=44, smax=33
        // -->right comp = max=44, smax=33

        // left =77, right=99
        // -->left comp = max=77, smax=44
        // --> right comp = max=99, smax=77
        // left=88 , right=88

        // --> left comp , max=99, smax=88
        // --> right comp, max=99, smax=88

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            // first compare largest with left element
            if (arr[left] > max) {
                secMax = max;
                max = arr[left];
            } else if (arr[left] > secMax && arr[left] < max) {
                secMax = arr[left];
            }

            // then compare largest with right element
            if (arr[right] > max) {
                secMax = max;
                max = arr[right];
            } else if (arr[right] > secMax && arr[right] < max) {
                secMax = arr[right];
            }
            left++;
            right--;
        }
        return secMax;
    }

    public static void main(String[] args) {
        int[] arr = { 88, 22, 33, 44, 55, 11, 55, 88, 77 };
        System.out.println("2nd largest element is : " + getSecondLargestElement(arr));
        System.out.println("2nd largest element : " + secondLargestElementOptimized(arr));
        System.out.println("2nd largest element is : " + getSecondLargestElementTwoPointer(arr));
    }
}
