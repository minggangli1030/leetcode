import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc90RecursionTreeFaster {

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
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);
        subset.removeLast();

        // Every level can either have element {a} or not have any {a}
        // Once decided not to have {a}, skip all the duplicate {a} in nums for faster processing
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, index + 1, subset, res);

    }


    public static void main(String[] args) {
        lc90RecursionTreeFaster solution = new lc90RecursionTreeFaster();

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
