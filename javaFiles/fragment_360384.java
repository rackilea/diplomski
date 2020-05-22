public static void main(String[] args) {
    boolean[] all = { false, true };
    for (boolean a : all) {
        for (boolean b: all) {
            boolean c = a ^ b;
            System.out.println(a + " ^ " + b + " = " + c);
        }
    }
}