package intertInterval;

import java.util.ArrayList;
import java.util.List;
/**
 * http://www.lintcode.com/en/problem/insert-interval/
 * https://www.jiuzhang.com/solutions/insert-interval/#tag-highlight
 * @author wsz
 * @date 2018Äê4ÔÂ12ÈÕ
 */
public class Solution {

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 2));
		list.add(new Interval(5, 9));
		
		System.out.println(insert2(list,new Interval(2, 122)));
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		if (newInterval == null || intervals == null) {
            return intervals;
        }
		
		List<Interval> results = new ArrayList<Interval>();
		int insertPos = 0;
		for (Interval interval : intervals) {
			if(interval.end < newInterval.start) {
				results.add(interval);
	            insertPos++;
			}else if (interval.start > newInterval.end) {
                results.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
		}
		results.add(insertPos, newInterval);
		return results;
	}
	
	public static List<Interval> insert2(List<Interval> intervals, Interval newInterval){
		 List<Interval> ans = new ArrayList<>();
	
		 int idx = 0;
		 while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
		     idx++;
		 }
		 intervals.add(idx, newInterval);
		
		 Interval last = null;
		 for (Interval item : intervals) {
		     if (last == null || last.end < item.start) {
		         ans.add(item);
		         last = item;
		     } else {
		         last.end = Math.max(last.end, item.end); // Modify the element already in list
		     }
		 }
		 return ans;
	}
	
}
