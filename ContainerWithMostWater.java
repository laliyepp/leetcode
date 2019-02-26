import java.util.Arrays;
import java.util.Comparator;

public class ContainerWithMostWater {
    public class Solution {
        public int maxArea(int[] height) {
            int[][] heightList = new int[height.length][2];
            int maxArea=-1;
            for (int i=0;i<height.length;i++){
                heightList[i] = new int[]{i,height[i]};
            }

            Arrays.sort(heightList, new Comparator<int[]>() {
                public int compare(int[] t1, int[] t2) {
                    return Integer.compare(t2[1],t1[1]);
                }
            });

            int left = Math.min(heightList[0][0],heightList[1][0]);
            int right = Math.max(heightList[0][0],heightList[1][0]);
            maxArea = (right-left) * Math.min(heightList[0][1],heightList[1][1]);

            for (int j=2;j<heightList.length;j++){
                if (heightList[j][0]>right){
                    right = heightList[j][0];
                    maxArea=Math.max(maxArea,(right-left)*heightList[j][1]);
                } else if (heightList[j][0] <left){
                    left = heightList[j][0];
                    maxArea=Math.max(maxArea,(right-left)*heightList[j][1]);
                }
            }

            return maxArea;
        }
    }
}