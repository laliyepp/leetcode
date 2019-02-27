import java.util.Arrays;

public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int nearest = nums[0] + nums[1] + nums[2];
            for (int i=0;i<nums.length-2;i++){
                int targetOfLargerTwoIntegers = target - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left<right) {
                    int threeSumNow = nums[i] + nums[left] + nums[right];
                    if (nums[left] + nums[right] == targetOfLargerTwoIntegers)
                        return target;
                    else {
                        if (nums[left] + nums[right] < targetOfLargerTwoIntegers){
                            if(Math.abs(threeSumNow-target)<Math.abs(nearest-target))
                                nearest = threeSumNow;
                            left++;
                        }
                        else {
                            if(Math.abs(threeSumNow-target)<Math.abs(nearest-target))
                                nearest = threeSumNow;
                            right--;
                        }
                    }
                }
            }
            return nearest;
        }
    }
}
