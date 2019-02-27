import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length<3)
                return new LinkedList<>();
            Arrays.sort(nums);
            List<List<Integer>> finalList = new LinkedList<>();
            for (int i=0;i<nums.length-2;i++){
                if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                    int left = i + 1;
                    int right = nums.length - 1;
                    int sum = 0 - nums[i];

                    while (left < right) {
                        int leftNum = nums[left];
                        int rightNum = nums[right];
                        if (sum == leftNum + rightNum) {
                            finalList.add(Arrays.asList(nums[i], leftNum, rightNum));
                            while (left < right && nums[left] == nums[left + 1])
                                left++;
                            while (left < right && nums[right] == nums[right - 1])
                                right--;
                            left++;
                            right--;
                        } else if (sum > leftNum + rightNum)
                            left++;
                        else
                            right--;
                    }
                }
            }
            return finalList;
        }
    }
}
