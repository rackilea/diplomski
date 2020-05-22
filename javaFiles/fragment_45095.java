public static void main(String[] args) {
    String k0="\"v0\"";
    String k1="\"v 1\"";
    String k2="\"v2 ";

    System.out.println("export k0 =" + k0 + " is valid : " + validateInput(k0));
    System.out.println("export k1 =" + k1 + " is valid : " + validateInput(k1));
    System.out.println("export k2 =" + k2 + " is valid : " + validateInput(k2));
}