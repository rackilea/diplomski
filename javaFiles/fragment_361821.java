public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
        System.out.println(i + "-" + HalfOfInt(i));
        //                              ^-----------call your method which
                                                  //take an int and return the (i/2)
        //                 ^-------------------------Print your value
    }
}

public static double HalfOfInt(int i) {
    return (double) i / 2;//<<----------- no need to use a loop just return (i/2)
}