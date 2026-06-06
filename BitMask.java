import java.util.Scanner;

public class BitMask{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int L = s.length();

        for (int ctr = 1; ctr < (1 << L); ctr++) {
            StringBuilder combi = new StringBuilder();

            for (int sh = 0; sh < L; sh++) {
                if ((ctr & (1 << sh)) > 0) {
                    // it is a set bit
                    combi.append(s.charAt(sh));
                }
            }
            System.out.println(combi);
        }
    }
}
