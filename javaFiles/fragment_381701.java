class Test {
    static void checkResult (String input) {
        String [] arr = input.split ("\\-");
        System.out.println ("Input   : '" + input + "'");
        System.out.println ("    Size: " + arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println ("    Val : '" + arr[i] + "'");
        System.out.println();
    }

    public static void main(String[] args) {
        checkResult ("thirty-two");
        checkResult ("five");
    }
}