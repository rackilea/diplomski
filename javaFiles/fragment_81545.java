public static void main(String[] args) {
    File file = new File("D:\\SunilKanjar");
    String[] files = file.list();
    for (String string : files) {
        if (string.lastIndexOf(".") > 0) {
            System.out.println(string.substring(0, string.lastIndexOf(".")));
        }
    }
}