package algorithm.data_structure.array;

/**
 * Leetcode 209 长度最小的子数组
 * 正整数数组nums 正整数target
 * 返回和>=target的(连续)子数组的最小长度
 * 若不存在子数组 返回0
 * */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = 0;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            while(sum >= target){
                if(minLen == 0 || right - left + 1 < minLen)
                    minLen = right - left + 1;
                sum -= nums[left];
                left++;
            }
        }
        return minLen;
    }
}
