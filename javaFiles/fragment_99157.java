long l = 1234;
    int[] results = new int[16];
    for (int i=15; i>=0; i--)
    {
        int index = (int)l & 0xF;
        results[i] = index;
        l = l >> 4;
    }