import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the binary string: ");
        String a = sc.next();

        HashMap<Integer, Integer> diff = new HashMap<>();
        diff.put(0, -1);

        int l = 0;
        int c0 = 0, c1 = 0;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) == '0')
                c0++;
            else
                c1++;

            int d = c0 - c1;

            if (diff.containsKey(d))
                l = Math.max(l, i - diff.get(d));
            else
                diff.put(d, i);
        }

        System.out.println(
            "Length of the longest substring with equal 0s and 1s: " + l
        );
    }
}
