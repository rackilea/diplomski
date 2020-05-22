public static int[] toIntArray(long x) {
    int neg = (x<0)?1:0;
    final char[] c = String.valueOf(x).toCharArray();
    final int s = c.length-neg;
    final int[] d = new int[s];
    for (int i = 0; i < s; i++) {
        d[i] = Character.getNumericValue(c[i+neg]);
    }
    if (neg==1) {
        d[0] = d[0] * -1;
    }
    return d;
}

public static int[] toIntArray2(long x) {
    int neg = (x<0)?1:0;
    final int s = String.valueOf(x).length()-neg;
    final int[] d = new int[s];
    for(int i =s-1 ; i > -1; i--) {
        d[i] = (int) (x%10);
        x = x/10;
    }
    return d;
}

public static Object[] toIntArray3(long x) {
    Deque<Integer> d = new ArrayDeque<Integer>(10);
    if(x==0){
        d.push(0);
        return d.toArray();
    }
    while(x != 0) {
        d.push((int) (x%10));
        x = x/10;
    }
    return  d.toArray();
}

public static int[] toIntArray4(long x) {
    int neg = (x<0)?1:0;
    final String[] c = String.valueOf(x).split("");
    final int s = c.length-neg;
    final int[] d = new int[s-1];
    for (int i = 1; i < s; i++) {
        d[i-1] = Integer.parseInt(c[i+neg]);
    }
    if (neg==1) {
        d[0] = d[0] * -1;
    }
    return d;
}