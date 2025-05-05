import java.util.ArrayList;
import java.util.List;

public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res); // backtracking
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset)); // why not res.add(subset) -> list shares the same reference
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        subset.removeLast(); // recover
        //subset.remove(subset.size() - 1)
        dfs(nums, index + 1, subset, res);

    }

    public static void main(String[] args) {
        lc78 solution = new lc78();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println("Example 1 Output: " + result1);
        // Expected: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        // Test Case 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println("Example 2 Output: " + result2);
        // Expected: [[],[0]]
    }

}

