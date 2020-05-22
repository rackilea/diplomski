int overtakings = 0;
    for (int i = 1; i < n; ++i) {
        if (finish.get(i) < finish.get(i-1)) {
            ++overtakings;
        }
    }