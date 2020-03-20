import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Title:      56. Merge Intervals
 * Source:     https://leetcode.com/problems/merge-intervals/
 * Difficulty: Medium
 *
 * Description:
 *    Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *    Input: [[1,3],[2,6],[8,10],[15,18]]
 *    Output: [[1,6],[8,10],[15,18]]
 *    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *    Input: [[1,4],[4,5]]
 *    Output: [[1,5]]
 *    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE:
 *    input types have been changed on April 15, 2019. Please reset to default code definition
 *    to get new method signature.
 */
public class MergeIntervals {

  public static void main(String[] args) {
    new MergeIntervals().merge(Collections.emptyList());

  }

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() < 2) {
      return intervals;
    }

    Comparator<Interval> comparable = new Comparator<Interval>() {
      @Override
      public int compare(Interval t1, Interval t2) {
        return t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start;
      }
    };

    Collections
        .sort(intervals, (t1, t2) -> t1.start == t2.start ? t1.end - t2.end : t1.start - t2.start);
    List<Interval> res = new ArrayList<>();
    Interval current = intervals.get(0);
    res.add(current);
    for (int i = 1; i < intervals.size(); i++) {
      Interval interval = intervals.get(i);
      if (current.end >= interval.start) {
        current.end = Math.max(current.end, interval.start);
      } else {
        current = interval;
        res.add(current);
      }
    }
    Arrays.asList(res);
    return res;
  }
}

class Interval implements Comparable<Interval> {

  int start;
  int end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(Interval interval) {
    return this.start == interval.start ? this.end - interval.end : this.start - interval.end;
  }
}
