package algorithm.data_structure.array;

/**
 * Leetcode 27 移除元素
 * 数组nums 值val
 * 1.返回nums中与val不同的元素的数量(设为k)
 * 2.更改nums数组，使nums的前k个元素=nums去掉val后的元素
 *
 * 双指针法/快慢指针法
 * */
public class RemoveElement {
    /**
     * 双重for循环暴力解法
     * 每次遇到删除元素 所有未删除元素移动一次 = 双重循环
     * 时间复杂度 O(n^2)
     * */
    public static int removeElementBruteForce(int[] nums, int val) {
        // 记录已删除元素个数
        int k = 0;

        // 从尾到头遍历数组
        // 其实从头到尾可能更好写 我只是脑子抽了
        for(int i = nums.length - 1; i >= 0;i--){
            // 发现待删除元素
            if(nums[i] == val){
                // 从待删除元素的后一个元素遍历到最后一个未删除元素 i.e. 总元素 - 已删除元素个数
                for(int j = i + 1; j < nums.length - k; j++){
                   // 将该元素前移
                   nums[j - 1] = nums[j];
                }

                // 删除元素 记录个数
                k++;
            }
        }

        // 返回未删除元素个数
        return nums.length - k;
    }

    /**
     * 双指针法
     * 慢指针标记未删除元素应该在的位置
     * 遇到未删除元素 直接一步到位 = 单次循环
     * 时间复杂度 O(n)
     * */
    public static int removeElementDoubleIndex(int[] nums, int val) {
        // 慢指针 遍历删除后数组
        int index = 0;

        // 快指针 遍历数组
        for(int i = 0; i < nums.length; i++){
            // 若快指针遍历到不用删除的元素
            if(nums[i] != val){
                // 慢指针也需要遍历该元素
                // 快指针的nums[i]其实就是慢指针的nums[index]
                if(index < i) nums[index] = nums[i];
                // 慢指针前进到下一位置
                index++;
            }

            // 若快指针遍历到删除元素
            // 慢指针没有反应
        }

        // 返回慢指针最后停留的位置 = 删除后数组的长度
        return index;
    }
}
