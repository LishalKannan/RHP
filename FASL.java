import java.util.*;

public class FASL{

    public static int[] getLargestAndSecondLargest(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            return new int[]{-1, -1};
        }

        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        boolean isSecondLarge = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                if (i > 0) {
                    secondLarge = large;
                    isSecondLarge = true;
                }
                large = arr[i];
            } else if (arr[i] > secondLarge && arr[i] != large) {
                secondLarge = arr[i];
                isSecondLarge = true;
            }
        }

        if (!isSecondLarge) {
            secondLarge = large;
        }

        return new int[]{large, secondLarge};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = getLargestAndSecondLargest(arr);

        System.out.println("Largest element: " + result[0]);
        System.out.println("Second largest element: " + result[1]);

        sc.close();
    }
}
