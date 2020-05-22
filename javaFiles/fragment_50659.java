public static void main(String[] args) {

    //same colors
    String hex = "#ffffff00";
    Color color = new Color(255,255,255,0);

    //4294967040
    System.out.println(Long.decode(hex));

    //16777215
    System.out.println(toRGBA(hex));

    //16777215
    System.out.println(color.getRGB());

    //-16711681
    System.out.println(toARGB(hex));
}

public static int toRGBA(String nm) {
    Long intval = Long.decode(nm);
    long i = intval.intValue();


    int a = (int) ((i >> 24) & 0xFF);
    int r = (int) ((i >> 16) & 0xFF);
    int g = (int) ((i >> 8) & 0xFF);
    int b = (int) (i & 0xFF);

    return ((b & 0xFF) << 24) |
            ((g & 0xFF) << 16) |
            ((r & 0xFF) << 8)  |
            ((a & 0xFF) << 0);
}

public static int toARGB(String nm) {
    Long intval = Long.decode(nm);
    long i = intval.intValue();


    int a = (int) ((i >> 24) & 0xFF);
    int r = (int) ((i >> 16) & 0xFF);
    int g = (int) ((i >> 8) & 0xFF);
    int b = (int) (i & 0xFF);

    return ((a & 0xFF) << 24) |
            ((b & 0xFF) << 16) |
            ((g & 0xFF) << 8)  |
            ((r & 0xFF) << 0);
}