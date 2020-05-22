for (int i = 0; i < no.length; i++) {
    int x = no[i];
    if (x % 2 == 0) continue;
    int y = (int) Math.sqrt(x);
    if (x == y * y) { 
        System.out.println(x);
    }
}