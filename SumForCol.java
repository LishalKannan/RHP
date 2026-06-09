import java.util.*;

public class SumForCol {

    public static int[] findFirstSecondIdx(int[] arr) {
        int firstIdx = (arr[0] >= arr[1]) ? 0 : 1;
        int secondIdx = (arr[0] >= arr[1]) ? 1 : 0;

        for (int i = 1; i < arr.length; i++) {
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

        int[] maxPair = findFirstSecondIdx(arr[0]);
        int first = maxPair[0];
        int second = maxPair[1];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] += (j != first)
                        ? dp[i - 1][first]
                        : dp[i - 1][second];
            }

            maxPair = findFirstSecondIdx(dp[i]);
            first = maxPair[0];
            second = maxPair[1];
        }

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        System.out.println(maxi);

        sc.close();
    }
}
