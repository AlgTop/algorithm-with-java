package algorithm.data_structure.array;

/**
 * Leetcode 704 二分查找
 * 给定升序整型数组(nums)和目标整数(target)
 * 若目标整数存在返回数组下标
 * 否则返回 -1
 *
 * 二分查找的麻烦点就是有两个版本(左闭右开/左闭右闭) 细节比较难记
 * 其实只需要记忆两个不同的条件S 其他的细节都可以推出来
 * 条件S(左闭右开) 如果target存在 那么 left <= targetIndex < right
 * 条件S(左闭右闭) 如果target存在 那么 left <= targetIndex <= right
 * */
public class BinarySearch {
    /**
     * I 暴力解法
     * 没有使用到升序的条件
     * */
    public int bruteForceSearch(int[] nums, int target) {
        // 循环数组
        for(int i=0;i<nums.length;i++){
            // 若找到目标整数 则返回数组下标
            if(nums[i]==target) return i;
        }
        // 否则返回-1
        return -1;
    }

    /**
     * II 二分查找经典版(左闭右开)
     * 数组升序 即 nums[i]<nums[j] -> i<j
     * 如果target存在 定义targetIndex满足 nums[targetIndex]=target
     * */
    public int binarySearchClassic(int[] nums, int target) {
        // 要点: 定义 left 和 right 变量
        //      使它们全程保持如下条件S
        //      如果target存在 那么 left <= targetIndex < right

        // 定义初始值
        int left = 0;
        int right = nums.length;
        // 0 <= targetIndex < nums.length 符合条件S

        // 进入循环 则left<right
        while(left < right){
            int middle = (left + right) / 2;

            // target < nums[middle]
            // 由升序可知 若target存在 则targetIndex<middle
            // right赋值为middle 符合条件S
            if(target < nums[middle]) right = middle;

            // 找到target 返回targetIndex
            else if(target == nums[middle]) return middle;

            // nums[middle] < target
            // 由升序可知 若target存在 则middle<targetIndex 即middle+1<=targetIndex
            // left赋值为middle+1 符合条件S
            else left = middle + 1;

            // 一次循环后 条件S仍然满足

            // 本循环不会无限进行
            // 只需说明: 每次循环后 若没找到target 则right-left变小 (故循环不会无限进行)
            // 一次循环后 若没找到target 只有两种情况 left赋值middle+1 或者 right赋值middle
            // 第一种情况 right-left必变小
            // 第二种情况 因为middle<=(left+right)/2<right 故right-left也是必变小
        }
        // 退出循环 则 left>=right
        // 若target存在 由条件S可知 left<right
        // 故target不存在 返回-1
        return -1;
    }

    /**
     * III 二分查找左闭右闭
     * 只是把II中的条件S改成 如果target存在 那么 left <= targetIndex <= right
     * 只保留与条件S相关的注释
     * */
    public int binarySearchRightClosed(int[] nums, int target) {
        // 0 <= targetIndex <= nums.length-1 符合条件S
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middle = (left + right) / 2;

            // targetIndex<=middle-1
            if(target < nums[middle]) right = middle - 1;
            else if(target == nums[middle]) return middle;
            // middle+1<=targetIndex
            else left = middle + 1;

            // 一次循环后 若没找到target 只有两种情况 left赋值middle+1 或者 right赋值middle-1
            // right-left必变小 循环不会无限进行
        }
        // 退出循环 则 left>right
        // 若target存在 由条件S可知 left<=right
        // 故target不存在 返回-1
        return -1;
    }
}
