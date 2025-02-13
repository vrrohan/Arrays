/*
 * Find maximum number of consecutive ones in a binary array and return its length
 * 
 * Example - arr=[0,1,0,1,1,1,0,0,1,1], max consecutive ones are = 3
 */
public class MaxConsecutiveOnes {

    /*
     * This method will count ones of arr[i]==1, when arr[i]==0 - it will stop
     * counting ones and calculate maxOnes
     * 
     * Example - arr=[1,0,1,1,0,0,1], maxOne=0, currOne=0
     * arr[0]==1, currOne=1, maxOne=0
     * arr[1]==0, currOne=0, maxOne=1
     * arr[2]==1, currOne=1, maxOne=1
     * arr[3]==1, currOne=2, maxOne=1
     * arr[4]==0, currOne=0, maxOne=2
     * arr[5]==0, currOne=0, maxOne=2
     * arr[6]==1, currOne=1, maxOne=2
     * 
     * tc - O(n)
     * sc - O(1)
     */
    static int maxConsecutiveOnes(int[] arr) {
        int maxConsecutiveOnesSize = 0;
        int currMaxOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currMaxOne = 0;
            } else {
                currMaxOne++;
                maxConsecutiveOnesSize = Math.max(currMaxOne, maxConsecutiveOnesSize);
            }
        }
        return maxConsecutiveOnesSize;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1 };
        System.out.println("max consecutive ones are : " + maxConsecutiveOnes(arr));
    }
}
