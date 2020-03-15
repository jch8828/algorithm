/**
 * Source:     https://leetcode.com/problems/maximum-subarray/
 * Difficulty: Easy
 *
 * Description:
 *    Given an integer array nums, find the contiguous subarray (containing at least one number)
 *    which has the largest sum and return its sum.
 *
 * Example:
 *    Input: [-2,1,-3,4,-1,2,1,-5,4],
 *    Output: 6
 *    Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.printf("Max subarray of [-2,1,-3,4,-1,2,1,-5,4]: %s\n", maximumSubarray(nums));

    int[] nums2 = {-2, -1, -3, -4, -1, -2, 1, -5, 4};
    System.out.printf("Max subarray of [-2,-1,-3,-4,-1,-2,1,-5,4]: %s\n", maximumSubarray(nums2));
//    System.out.printf("Max subarray of null: %s\n", maximumSubarray(null));

    int[] nums3 = {5, 4};
    System.out.printf("Max subarray of [5,4]: %s\n", maximumSubarray(nums3));
  }

  public static int maximumSubarray(int[] nums) {
    if (nums == null || nums.length < 1) {
      throw new IllegalArgumentException("Empty array");
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int max = nums[0];
    int current = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // Max of current + nums[i], nums[i] and max
      current = Math.max(current + nums[i], nums[i]);
      max = Math.max(current, max);
    }
    return max;
  }

}
