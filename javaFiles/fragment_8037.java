for (int num : tab) {
    if (num == 0) {
        count0++;
        if (count1 > 0) {
            System.out.println(count1);
            count1 = 0;
        }
    } else {
        count1++;
        if (count0 > 0) {
            System.out.println(count0);
            count0 = 0;
        }
    }
}
System.out.println(Math.max(count0, count1));