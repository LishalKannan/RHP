```java
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int testCase = fs.nextInt();

        for (int t = 1; t <= testCase; t++) {

            out.append("Case ").append(t).append(":\n");

            int n = fs.nextInt();
            int q = fs.nextInt();

            int[] array = new int[n + 1];

            HashMap<Integer, ArrayList<Integer>> indices = new HashMap<>();

            // Input array
            for (int i = 1; i <= n; i++) {

                int x = fs.nextInt();

                array[i] = x;

                indices
                    .computeIfAbsent(x, k -> new ArrayList<>())
                    .add(i);
            }

            // Queries
            while (q-- > 0) {

                int c = fs.nextInt();

                if (c == 1) {

                    int x = fs.nextInt();
                    int y = fs.nextInt();

                    if (x == y)
                        continue;

                    // Change all x's to y
                    ArrayList<Integer> xIndices = indices.get(x);

                    for (int k : xIndices) {
                        array[k] = y;
                    }

                    // Move indices of x into y
                    indices
                        .computeIfAbsent(y, k -> new ArrayList<>())
                        .addAll(xIndices);

                    // Remove x
                    indices.remove(x);

                } else {

                    int x = fs.nextInt();

                    out.append(array[x]).append('\n');
                }
            }
        }

        System.out.print(out);
    }

    // Fast input
    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int num = 0;

            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }

            return num * sign;
        }
    }
}
```
