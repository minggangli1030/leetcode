import java.util.*;

public class lc90HashSet {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), set);
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> subset, Set<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        subset.removeLast(); // recover
        //subset.remove(subset.size() - 1)
        dfs(nums, index + 1, subset, res);
    }

    public static void main(String[] args) {
        lc90HashSet solution = new lc90HashSet();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsetsWithDup(nums1);
        System.out.println("Example 1 Output: " + result1);
        // Expected: [[],[1],[1,2],[1,2,2],[2],[2,2]]

        // Test Case 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println("Example 2 Output: " + result2);
        // Expected: [[],[0]]

    }


}
