import java.util.Arrays;

/**
 A zero-indexed array A consisting of N integers is given. An equilibrium index of
 this array is any integer P such that 0 ≤ P < N and the sum of elements of lower
 indices is equal to the sum of elements of higher indices, i.e.

 A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].

 Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.

 For example, consider the following array A consisting of N = 8 elements:
 A[0] = -1
 A[1] =  3
 A[2] = -4
 A[3] =  5
 A[4] =  1
 A[5] = -6
 A[6] =  2
 A[7] =  1

 P = 1 is an equilibrium index of this array, because:

 A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]

 P = 3 is an equilibrium index of this array, because:

 A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]

 P = 7 is also an equilibrium index, because:

 A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0

 and there are no elements with indices greater than 7.

 P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a zero-indexed array A consisting of N integers, returns any of its
 equilibrium indices. The function should return −1 if no equilibrium index exists.

 For example, given array A shown above, the function may return 1, 3 or 7, as explained above.

 Assume that:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

 Elements of input arrays can be modified.


 https://stackoverflow.com/questions/4439595/how-to-create-a-sub-array-from-another-array-in-java

 **/
public class MyExercise {

    public static void main(String[] args) {
//        int[] test = new int[]{-1, 3, -4, 5, 1, -6, 2,1};
        int[] test = new int[]{31};
        MyExercise myExercise = new MyExercise();
        System.out.println("equilibrium: " + myExercise.solution(test));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int index = A.length - 1;
        while (index > -1) {
            index = equilibrium(A, index);
            System.out.println("bucle: " + index);
            index --;
        }
        return index;
    }

    private int equilibrium(int[] A, int index) {

//        System.out.println("index: " + index);
        if (index < 0  || index > 100000) return -1; // no equilibrium
        if (index == 0) {
            int[] tmp = Arrays.copyOfRange(A, index + 1, A.length);
            int total = getTotalSum(tmp);
            if (total == 0) {
                return index;
            } else return -1;
        } else if (index == A.length -1) {
            int[] tmp = Arrays.copyOfRange(A, 0, A.length -1);
            int total = getTotalSum(tmp);
            if (total == 0) {
                return index;
            } else return -1;
        } else {
            int[] rightTmp = Arrays.copyOfRange(A, 0, index);
            int[] leftTmp = Arrays.copyOfRange(A, index + 1, A.length);
            int totalRightSum = getTotalSum(rightTmp);
            int totaLeftSum = getTotalSum(leftTmp);
            if (totalRightSum == totaLeftSum) {
                return index;
            }
        }

        return equilibrium(A, --index);
    }

    private int getTotalSum(int[] tmp) {
        int total = 0;
        for (int number : tmp) {
            total += number;
        }
        return total;
    }

    private String printArray(int[] array) {
        String tmpS = "[";
        for (int tmp : array) {
            tmpS += tmp + ",";
        }
        return tmpS + "]";
    }

}

