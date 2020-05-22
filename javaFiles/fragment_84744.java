BitSet bitSet = BitSet.valueOf(new long[] {123});
    int count = 0;
    int max = 0;
    for (int i=0; i < bitSet.size(); i++) {
        if(bitSet.get(i)) {
            count++;
        } else {
            max = Math.max(max, count);
            count = 0;
        }
    }
    System.out.println(max);