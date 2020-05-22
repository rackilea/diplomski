int count = 0;
for (int i1 = 0; i1 <= 9; i1++) {
    for (int i2 = 0; i2 <= 9; i2++) {
        for (int i3 = 0; i3 <= 9; i3++) {
            int sum = i1 + i2 + i3;
            for (int i4 = Math.max(0, sum - 18); i4 <= Math.min(9, sum); i4++) {
                int min5 = Math.max(0, sum - i4 - 9);
                int max5 = Math.min(9, sum - i4);
                if (min5 <= max5) // one solution for i6 each
                    count += max5 - min5 + 1;
            }
        }
    }
}
System.out.println(count);