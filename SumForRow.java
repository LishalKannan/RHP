import java.util.*;

public class SumForRow {

    public static int[] findFirstSecondIdx(int[] arr) {
        if (arr.length < 2) {
            return new int[]{0, 0};
        }

        int firstIdx = (arr[0] >= arr[1]) ? 0 : 1;
        int secondIdx = (arr[0] >= arr[1]) ? 1 : 0;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] >= arr[firstIdx]) {
                secondIdx = firstIdx;
                firstIdx = i;
            } else if (arr[i] > arr[secondIdx]) {
                secondIdx = i;
            }
        }

        return new int[]{firstIdx, secondIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxi = -1;

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = arr[i][j];
            }
        }

        int[] colm = new int[n];
        for (int i = 0; i < n; i++) {
            colm[i] = dp[i][0];
        }

        int[] maxPair = findFirstSecondIdx(colm);
        int first = maxPair[0];
        int second = maxPair[1];

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] += (i != first)
                        ? dp[first][j - 1]
                        : dp[second][j - 1];
            }

            for (int i = 0; i < n; i++) {
                colm[i] = dp[i][j];
            }

            maxPair = findFirstSecondIdx(colm);
            first = maxPair[0];
            second = maxPair[1];
        }

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[i][m - 1]);
        }

        System.out.println(maxi);

        sc.close();
    }
}Maximum Sum Path Across Columns Without Repeating the Same Row
