for (int i = 0; i < q; i++) {
            if (t[i] != s[i]) {
                if (t[i] > s[i]) {
                    return true;
                } else if (t[i] < s[i]) {
                    return false;
                }
            }
        }