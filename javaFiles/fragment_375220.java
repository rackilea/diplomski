int count = 0;
for (int i1 = 0; i1 <= 9; i1++) {
    for (int i2 = 0; i2 <= i1; i2++) {
        for (int i3 = 0; i3 <= i2; i3++) {
            int different = ((i1 != i2)?1:0) + ((i1 != i3)?1:0) + ((i2 != i3)?1:0);
            int combinations = different == 0 ? 1 : different == 2 ? 3 : 6;
            int sum = i1 + i2 + i3;
            for (int i4 = Math.max(0, sum - 18); i4 <= Math.min(9, sum); i4++) {
                int min5 = Math.max(0, sum - i4 - 9);
                int max5 = Math.min(9, sum - i4);
                if (min5 <= max5) // one solution each
                    count += combinations * (max5 - min5 + 1);
            }
        }
    }
}
System.out.println(count);