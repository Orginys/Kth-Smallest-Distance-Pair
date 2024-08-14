import java.util.Arrays;

public class Solution {  // Изменили название класса на Solution
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0, j = 0;

            for (int i = 0; i < nums.length; i++) {
                while (j < nums.length && nums[j] - nums[i] <= mid) {
                    j++;
                }
                count += j - i - 1;
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println(solution.smallestDistancePair(nums1, k1)); // Вывод: 0

        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(solution.smallestDistancePair(nums2, k2)); // Вывод: 0

        int[] nums3 = {1, 6, 1};
        int k3 = 3;
        System.out.println(solution.smallestDistancePair(nums3, k3)); // Вывод: 5
    }
}