public static void main(String[] args) {

    for (int i = 1; i <= 100; i++) {
        if (((i % 3) == 0) && ((i % 7) == 0))
            System.out.println("OnBase");
        else if ((i % 3) == 0)
            System.out.println("On");
        else if ((i % 7) == 0)
            System.out.println("Base");
        else
            System.out.println(i);
    }
}