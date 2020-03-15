import java.util.ArrayList;
import java.util.List;

/**
 * Source:     https://leetcode.com/problems/generate-parentheses/
 * Difficulty: Medium
 * Note:
 *     Given n pairs of parentheses, write a function to generate all combinations of well-formed
 *     parentheses.
 * Example:
 *    given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class GenerateParentheses {

  public static void main(String[] args) {
    List<String> res = new ArrayList<>();
    generateParentheses(2, 2, "", res);
    System.out.println(res);

  }

  //  Don't use StringBuilder since it passes by reference
  public static void generateParentheses(int left, int right, String path, List<String> res) {
    if (left == 0 && right == 0) {
      res.add(path.toString());
      return;
    }
    // Need to check the left > 0
    if (left > 0) {
      generateParentheses(left - 1, right, path + "(", res);
    }
    if (right > 0 && left < right) {
      generateParentheses(left, right - 1, path + ")", res);
    }
  }
}
