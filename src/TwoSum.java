import java.util.HashMap;
import java.util.Map;

/**
 * Source:     https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 *
 * Description:
 *    Given an array of integers, return indices of the two numbers such that they add up to a
 *    specific target. You may assume that each input would have exactly one solution, and you may
 *    not use the same element twice.
 *
 * Example:
 *    Given nums = [2, 7, 11, 15], target = 9,
 *
 *    Because nums[0] + nums[1] = 2 + 7 = 9,
 *    return [0, 1].
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] res = new TwoSum().twoSum(nums, target);

    System.out.printf("index 1: %s, index 2: %s", res[0], res[1]);
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

}
