/*
 * Find max average of any sub-array with window size k
 * 
 * Example - arr=[1,2,3,7,5,9,6], k=3 ==> [7,5,9] sub-array will give maximum average
 * 
 * Example - arr=[10,0,5,7,-4,-3,12,6], k=4 ==> [10,0,5,7] will give maximum average
 */
public class MaximumSubArrayAverage {

    /*
     * This method will traverse from 0 to arr.size - k, and on each traverse it
     * will traverse from i till k elements from i.
     * 
     * Example - arr=[1,2,3,4,5,6,7,8], k=4 ==> at i=0, j will traverse from i till
     * i+k-1 i.e. 0 till 3
     * at i=1, j will traverse from 1 till i+k-1 i.e. 1 to 4
     * at i=2, j will traverse from 2 till i+k-1 i.e. 2 to 5
     * 
     * tc - O(n*k), because for every i we iterate k window size ==> for n elements
     * of array, we iterate k times
     * sc - O(1)
     */
    static double maxAverageSubArray(int[] arr, int k) {
        double maxAvg = 0.0;
        for (int i = 0; i <= arr.length - k; i++) {
            double currAvg = 0.0;
            int sum = 0;
            for (int j = i; j <= (i + k - 1); j++) {
                sum += arr[j];
            }
            currAvg = (double) sum / k;
            maxAvg = Math.max(currAvg, maxAvg);
        }

        return maxAvg;
    }

    /*
     * This method will use sliding window approach to calculate maximum average sum
     * 
     * We will first calculate the sum & average of first k elements i.e. 0 to k-1
     * 
     * Then we will iterate from 1st index and keep on moving to right of array.
     * Hence, removing the leftmost element from array
     * and adding the next right element of array.
     * When removing the 1st element of window - we subtract current sum from that
     * element, and add new element to current sum.
     * 
     * Example - arr=[1,2,3,4,5,6], k=3 , sum of first window = 6
     * step-1 ==> i=1 i.e. move the window to right i.e. remove 1 from window and
     * add 4 to window ==> 6-1 = 5 and then 5+4=9
     * step-2 ==> move window to right i.e. remove 2 from window and add 5 to window
     * ==> 9-2=7 and then 7+5=12
     * step-3 ==> move window to right i.e. remove 3 from window and add 6 to window
     * ==> 12-3=9 and then 9+6=15
     * 
     * tc - O(n)
     * sc - O(1)
     */
    static double maxAverageOptimized(int[] arr, int k) {
        double maxAvg = 0.0;
        int sum = 0;

        // calculate sum of first k elements
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxAvg = (double) sum / k;

        for (int i = 1; i <= arr.length - k; i++) {
            double currAvg = 0.0;
            // first subtract the previous element which was removed from window
            sum -= arr[i - 1];
            // then add the new element which was added to window
            sum += arr[i + k - 1];
            // now calculate the new average and then compare it will maxAvg
            currAvg = (double) sum / k;
            maxAvg = Math.max(maxAvg, currAvg);
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 12, -5, -6, 50, 3 };
        System.out.println("max average sub-array is : " + maxAverageOptimized(arr, 4));
    }
}
