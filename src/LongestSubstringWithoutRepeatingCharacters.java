import java.util.HashMap;
import java.util.Map;

/**
 * Source:     https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Difficulty: Medium
 *
 * Description:
 *    Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *    Input: "abcabcbb"
 *    Output: 3
 *    Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *    Input: "bbbbb"
 *    Output: 1
 *    Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *    Input: "pwwkew"
 *    Output: 3
 *    Explanation: The answer is "wke", with the length of 3.
 *    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.printf("abcabcbb: %s\n", longestSubstring("abcabcbb"));
    System.out.printf("bbbbb: %s\n", longestSubstring("bbbbb"));
    System.out.printf("pwwkew: %s\n", longestSubstring("pwwkew"));

  }

  public static int longestSubstring(String s) {
    if (s == null) {
      throw new IllegalArgumentException();
    }
    if (s.length() < 1) {
      return s.length();
    }

    Map<Character, Boolean> map = new HashMap<>(); // could use HashSet here, HashMap is better
    int max = 0;
    int start = 0;
    int end = 0;
    while (end < s.length()) {
      max = Math.max(max, end - start); // calculate length before incrementing end
      char c = s.charAt(end++);
      if (map.containsKey(c)) {
        while (s.charAt(start) != c) {
          map.remove(s.charAt(start++));
        }
        start++; // move start index passing the original 'c' position
      } else {
        map.put(c, true);
      }
    }

    return max;
  }
}
