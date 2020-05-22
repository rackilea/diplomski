for (int i = 0; i < q; i++) {
            if (t[i] != s[i]) {
                if (t[i] > s[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }