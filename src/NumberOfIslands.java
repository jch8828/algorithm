/**
 * Source:     https://leetcode.com/problems/number-of-islands/
 * Difficulty: Medium
 *
 * Description:
 *    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island
 *    is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *    You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *    Input:
 *      11110
 *      11010
 *      11000
 *      00000
 *    Output: 1
 *
 * Example 2:
 *    Input:
 *      11000
 *      11000
 *      00100
 *      00011
 *    Output: 3
 */
public class NumberOfIslands {

  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'},
    };
    System.out.println(numberOfIslands(grid));
  }

  public static int numberOfIslands(char[][] grid) {
    if (grid == null) {
      throw new IllegalArgumentException();
    }
    int r = grid.length;
    int c = grid[0].length;
    int res = 0;

    for (int ic = 0; ic < c; ic++) {
      for (int ir = 0; ir < r; ir++) {
        if (grid[ir][ic] == '1') {
          res++;
          mark(ir, ic, r, c, grid);
        }
      }
    }
    return res;
  }

  private static void mark(int ir, int ic, int r, int c, char[][] grid) {
    if (ic < 0 || ic >= c) {
      return;
    }
    if (ir < 0 || ir >= r) {
      return;
    }
    if (grid[ir][ic] != '1') {
      return;
    }

    grid[ir][ic] = '.';
    mark(ir - 1, ic, r, c, grid);
    mark(ir + 1, ic, r, c, grid);
    mark(ir, ic - 1, r, c, grid);
    mark(ir, ic + 1, r, c, grid);
  }
}
