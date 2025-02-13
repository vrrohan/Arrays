/*
 * Add one to the integer number representation of array
 * 
 * Example - [1,0] ==> [1,1]
 * Example - [9,9] ==> [1,0,0]
 * Example - [1,9] ==> [2,0]
 * Example - [9,9,9] ==> [1,0,0,0]
 */
public class AddOneToArray {

    /*
     * This method will return the number after adding 1 to array
     * 
     * Example - [9,2] ==> add carry + arr[1] ==> carry=1 initially ==> 1+2=3, since
     * sum<9, carry will remain 0.
     * again==> carry + arr[0] ==> 0+9=9 ==> final sum = [9,3]
     * 
     * Example - [1,9,9], carry=1 ==> add carry + arr[2] ==> 9+1=10 ==> sum>9 ==>
     * carry=1 & sum>9 ==> arr[i] i.e. arr[2] = 0
     * arr[1] = 9 + carry (1) ==> 10 ==> again sum>9 ==> carry=1 & sum>9 ==>
     * arr[1]=0
     * arr[0]=1 + carry (1) ==> 2 ==> sum<9 ==> carry=0 && sum = 2 i.e. arr[0] = 2
     * Hence result array = [2,0,0]
     * 
     * tc - O(n)
     * sc - O(1)
     */
    static int[] addOneToArray(int[] arr) {
        int carry = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            // add carry to number - initially it is 1
            int sum = arr[i] + carry;
            // if sum>9 - it means carry will be 1 again or else it will be 0
            carry = (sum > 9) ? 1 : 0;
            // we will check if sum>9, we will add only 0 to array , since we are adding
            // only 1 to it
            arr[i] = (sum > 9) ? 0 : sum;
        }

        // after adding every index, if carry is still 1 - we will create a separate new
        // array of +1 length
        if (carry > 0) {
            int[] newArray = new int[arr.length + 1];
            // add carry to the first index of new array
            newArray[0] = carry;
            // copy everything from old array to new array
            for (int i = 0; i < arr.length; i++) {
                newArray[i + 1] = arr[i];
            }
            return newArray;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 9, 9 };
        int[] sumArray = addOneToArray(arr);
        for (int num : sumArray) {
            System.out.print(num + " ");
        }
    }
}
