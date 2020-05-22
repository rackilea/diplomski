int[] a = { 1, 2, 3, 4, 0, 19, 1, 1, 2, 2, 3, 3, 2 };

int count = 1, max = 1;

for (int i = 1; i < a.length; i++) {
    if (a[i] >= a[i - 1]) {
        count++;
    } else {
        count = 1;
    }

    if (count > max) {
        max = count;
    }
}

System.out.println(max);