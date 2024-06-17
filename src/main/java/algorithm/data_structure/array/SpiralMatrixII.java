package algorithm.data_structure.array;

/**
 * Leetcode 59 螺旋矩阵II
 * 正整数n
 * 返回n*n螺旋矩阵(二维数组)
 * <p>
 * 例如 输入3
 * 返回 int[3][3]
 * int[0] = {1,2,3}
 * int[1] = {8,9,4}
 * int[2] = {7,6,5}
 */
public class SpiralMatrixII {
    public int[][] generateMatrixPerStep(int n) {
        int[][] spiralMatrix = new int[n][n];

        int len = n;
        int dir = 0;
        int dist = 1;

        int i = 0;
        int j = 0;
        int val = 0;

        while (true) {
            val++;
            spiralMatrix[i][j] = val;

            if(len == 1) break;

            if (dir == 0) j++;
            if (dir == 1) i++;
            if (dir == 2) j--;
            if (dir == 3) i--;

            if (dist != len - 1) {
                dist++;
            } else {
                if (dir == 3) {
                    len -= 2;
                    if (len == 0) break;
                    i++;
                    j++;
                }
                dir = (dir + 1) % 4;
                dist = 1;
            }
        }

        return spiralMatrix;
    }

    public int[][] generateMatrixPerLoop(int n){
        int[][] spiralMatrix = new int[n][n];

        int i = 0;
        int j = 0;
        int val = 1;

        for(int len = n - 1; len >= 0 ; len -= 2){
            if(len == 0) {
                spiralMatrix[i][j] = val;
                break;
            }

            for(int k = 0; k < len; k++){
                spiralMatrix[i][j + k] = val + k;
                spiralMatrix[i + k][j + len] = val + len + k;
                spiralMatrix[i + len][j + len - k] = val + 2 * len + k;
                spiralMatrix[i + len - k][j] = val + 3 * len + k;
            }

            i++;
            j++;
            val += 4 * len;
        }

        return spiralMatrix;
    }
}
