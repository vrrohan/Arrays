/*
 * Find pair of numbers whose sum is equal to result.
 * Display both pair of numbers and their index.
 * 
 * Example - [2,4,7,11,15], sum=15 ==> pair=(4,11) && index=(1,3)
 * 
 * Example - [1,2,4,6,9,8,11], sum=10 ==> pair=(4,6), (2,8) & (1,9) && index=(0,4), (1,5) & (2,3)
 */

import java.util.HashMap;

public class TwoSum {

    /*
     * This method will iterate over array using 2 loops
     * loop 1 - iterate from 0 to arr.length-2
     * loop 2 - iterate from its next element till the end
     * 
     * tc - O(n2)
     * sc - O(n)
     */
    static void twoSumPair(int[] arr, int sum) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println("pair of number = (" + arr[i] + ", " + arr[j] + ")");
                    System.out.println("index = (" + i + ", " + j + ")");
                    System.out.println("=============================");
                }
            }
        }
    }

    /*
     * This method will use hashmap to store elements of array- get() to find
     * elements.
     * We will insert element e in hashmap, only if (sum-e) is not present in
     * hashmap, if find, we will have the pair sum and remove the element from
     * array.
     * 
     * Also to track the index - we will store the value as index of element
     * 
     * Example - [1,2,4,6,9,13,8], sum=15, HashMap = []
     * i=0, check if (sum - arr[i]) is present in hashmap ==> 15-1 = 14 not in
     * hashmap ==> insert 1 & its index in hashmap
     * HashMap = [1:0]
     * 
     * i=1, if (sum - arr[i]) is present in hashmap ==> 15-2 = 13 not in hashmap ==>
     * insert 2 & its index in hashmap
     * HashMap = [1:0, 2:1]
     * 
     * i=2, if (sum - arr[i]) is present in hashmap ==> 15-4=11 not in hashmap ==>
     * insert 4 & its index in hashmap
     * HashMap = [1:0, 2:1, 4:2]
     * 
     * i=3, if (sum - arr[i]) is present in hashmap ==> 15-6=9 not in hashmao ==>
     * insert 6 & its index in hashmap
     * HashMap = [1:0, 2:1, 4:2, 6:3]
     * 
     * i=4, (sum - arr[i]) is present in hashmap ==> 15-9=6 is present in hashmap
     * ==> no insertion. we get the pair
     * fetch the (sum - arr[i]) = 6 & its value (which is index of other pair
     * element)
     * later remove the other element i.e. 6 from the hashmap
     * 
     * tc - O(n)
     * sc - O(n)
     */
    static void twoPairSumOptimized(int[] arr, int sum) {
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();

        for (int i = 0; i <= arr.length - 1; i++) {
            int otherElementToFind = sum - arr[i];
            // get will have O(1) time complexity
            Integer mapValue = hMap.get(otherElementToFind);

            if (mapValue == null) {
                // If there is no such element of pair - we will insert in hashmap
                hMap.put(arr[i], i);
            } else {
                System.out.println("Pair sum is : (" + otherElementToFind + ", " + arr[i] + ")");
                System.out.println("Index of pair is : (" + mapValue + ", " + i + ")");
                System.out.println("==============");
                // remove the other element which is present in hashmap
                hMap.remove(otherElementToFind);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 8, 12, 13, 9 };
        // twoSumPair(arr, 10);
        twoPairSumOptimized(arr, 10);
    }
}
