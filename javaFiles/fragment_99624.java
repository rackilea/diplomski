public static String generatDiamond(int n) {
    String diamond = "";

    String spaces = ""; // used to store spaces
    String str = ""; // string to be printed every line
    char c = 'A';

    for (int i = n; i >= -n; i--) {
        // there needs to be |i| spaces, and the char needs to be printed 2 * (n - |i|) + 1 times.


        // generate spaces
        for (int j = 1; j <= Math.abs(i); j ++) {
            spaces += " ";
        }
        // add first spaces
        str += spaces;

        // add chars
        for (int j = 1; j <= 2* (n - Math.abs(i)) + 1; j ++) {
            str += c;
        }
        // add last spaces
        str += spaces;

        // add the line to the general shape
        diamond += str + "\n";

        // clear variable
        str = ""; spaces = "";

        // change the char
        if (i > 0)
            c++;
        else
            c--;
    }

    // shape is done, return it
    return diamond;
}

public static void main(String[] args){
    // testing sizes 0 to 10
    for (int i = 0; i <= 10; i++) {
        System.out.println("n = " + i);
        System.out.println(generatDiamond(i));
    }

}