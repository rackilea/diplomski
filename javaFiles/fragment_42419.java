for (int i = res.length - 1; i >= 0; i--) {
        if (res[i] > 9) {
            if (res[i] > 99) {
                res[i - 1] += ((res[i] / 100) % 10) * 10; // first digit (*10)
                res[i - 1] += (res[i] / 10) % 10; // second digit
            } else {
                res[i - 1] += (res[i] / 10) % 10; // left-digit
            }
            res[i] = res[i] % 10; // right-digit
        }
    }