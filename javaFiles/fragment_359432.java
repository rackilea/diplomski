public static void main(String[] args) {
    Random rand = new Random();
    for(int i=0; i<20; i++) {
        System.out.println("next: " + Long.toHexString(rand.nextLong()));
    }
    InvRand ir = new InvRand(rand);
    for(int i=0; i<20; i++) {
        System.out.println("prev: "+Long.toHexString(ir.prevLong()));
    }
}