class Playground {
    public static void main(String[ ] args) {
        String str = "1.05";
        int dotPos = str.indexOf(".");


        String res = Playground.removeByIndex(str, dotPos + 1);

        System.out.println(res);

    }

    private static String removeByIndex(String str, int index) {
        return str.replaceFirst(String.valueOf(str.charAt(index)), "");
    }
}