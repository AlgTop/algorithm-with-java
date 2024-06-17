package algorithm.data_structure.array;

/**
 * Leetcode 977 有序数组的平方
 * nums非递减排序
 * 返回由nums元素的平方组成的新数组
 * 且新数组也是非递减排序
 * */
public class SquaresOfASortedArray {
    /**
     * 双指针法
     * nums元素的平方中的最大值一定是原数组的最小值或最大值
     * */
    public int[] sortedSquares(int[] nums) {
        int[] squaresNums = new int[nums.length];

        // 左右指针
        int left = 0;
        int right = nums.length - 1;
        // 给新数组赋值的指针
        int newIndex = nums.length - 1;

        // 等价条件 newIndex==0
        while(left <= right) {
            // 二者是squaresNums未赋值的数字中最大的两个候选人
            int leftSquares = nums[left] * nums[left];
            int rightSquares = nums[right] * nums[right];

            // 将未赋值的最大的赋值给squaresNums[newIndex]
            // >=和>不影响 都可以
            if(leftSquares >= rightSquares){
                squaresNums[newIndex] = leftSquares;
                left++;
            } else {
                squaresNums[newIndex] = rightSquares;
                right--;
            }

            newIndex--;
        }

        return squaresNums;
    }
}
