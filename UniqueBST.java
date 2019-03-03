public class UniqueBST {
    class Solution {
        public int numTrees(int n) {
            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    result[i][j] = 0;
                }
            }
            result[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int k = Math.max(j - 1, 0); k < i; k++) {
                        result[i][j] += result[i - 1][k];
                    }
                }
            }
            int anwser = 0;
            for (int x = 0; x < n; x++)
                anwser += result[n - 1][x];
            return anwser;
        }
    }
}