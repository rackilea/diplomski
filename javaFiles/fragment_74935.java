public static void main(String[] args) {
    StringHolder[] holders = new StringHolder[]{new StringHolder("string 1")};
    StringHolder tmp = holders[0];
    holders[0] = new StringHolder("string 2");
    System.out.println(tmp); // string 1
    System.out.println(holders[0]); // string 2
}