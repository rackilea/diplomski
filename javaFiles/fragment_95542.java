public static void sort(ArrayList<Integer> arr, int left, int right) {
        int i = left - 1;
        int j = right + 1;
        if (right - i == 0 || right - i == 1) return;
        int v = arr.get(right);

        for (;;) {
            while (arr.get(++i) < v);
            while (v < arr.get(--j) && j != 0)
                if (j == 1) break;
            if (i >= j) break;

            Collections.swap(arr, i, j);
        }
        Collections.swap(arr, i, right);

        sort(arr, left, i - 1);
        sort(arr, i, right);
    }