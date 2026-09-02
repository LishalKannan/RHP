#include <bits/stdc++.h>
using namespace std;

const int MAXT = 200000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k, q;
    cin >> n >> k >> q;

    vector<int> diff(MAXT + 2, 0);

    // Step 1: Difference array
    for (int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        diff[l]++;
        if (r + 1 <= MAXT) diff[r + 1]--;
    }

    // Step 2: Build frequency array
    vector<int> freq(MAXT + 1, 0);
    for (int t = 1; t <= MAXT; t++) {
        freq[t] = freq[t - 1] + diff[t];
    }

    // Step 3: Mark admissible
    vector<int> admissible(MAXT + 1, 0);
    for (int t = 1; t <= MAXT; t++) {
        if (freq[t] >= k) admissible[t] = 1;
    }

    // Step 4: Prefix sum of admissible
    vector<int> prefix(MAXT + 1, 0);
    for (int t = 1; t <= MAXT; t++) {
        prefix[t] = prefix[t - 1] + admissible[t];
    }

    // Step 5: Answer queries
    while (q--) {
        int a, b;
        cin >> a >> b;
        cout << prefix[b] - prefix[a - 1] << "\n";
    }

    return 0;
}
