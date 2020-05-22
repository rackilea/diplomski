class Playground {
    public static void main(String[ ] args) {
        String str = "1.0505";
        int dotPos = str.indexOf(".");


        String res = Playground.removeByIndex(str, dotPos + 1);

        System.out.println(res);

    }

    private static String removeByIndex(String str, int index) {
        return new StringBuilder(str).deleteCharAt(index).toString();
    }
}