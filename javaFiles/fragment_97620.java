public void test() {
    int[] array = new int[20];
    int[] var2 = array;
    int var3 = array.length;

    for(int var4 = 0; var4 < var3; ++var4) {
        int var10000 = var2[var4];
        System.out.println("lol");
    }

}