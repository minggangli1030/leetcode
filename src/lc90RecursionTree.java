import java.util.*;

public class lc90RecursionTree {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        int count = 0; // Count the number of duplicate first to save extra space (less backtracking recursion)
        for (int i = index; i < nums.length && nums[i] == nums[index]; i++) {
            count ++;
            subset.add(nums[index]); // nums[i] work as well
        }

        for (int i = count; i > 0; i --) {
            dfs(nums, index + count, subset, res);
            subset.removeLast(); // reset
        }
        dfs(nums, index + count, subset, res);
    }


    public static void main(String[] args) {
        lc90RecursionTree solution = new lc90RecursionTree();

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
