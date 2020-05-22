class Loop {
    public static void main(String...args) throws Exception {
        long l = 0;
        for (int i = 0; i >= 0; i++) {
            for (int j = 0; j < 50; j++) {
            l++;
            }
        }
        System.out.println("will sleep now");
        Thread.sleep(30_000);
    }
}