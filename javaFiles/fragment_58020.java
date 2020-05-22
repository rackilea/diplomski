public class TrianglePrinter {
    public static void main(String[] args) {
        printDescendingTriangle(5);
    }

    private static void printDescendingTriangle(final int a) {
        StringBuilder str = initialStringBuilder(a);
        int i = 0;

        while(i < a){
            System.out.println(str);
            str.setCharAt(i,' ');  // here I'm replacing the '*' with a space ' ' character
            i++;
        }
    }

    // To initialize the StringBuilder with the ***** characters with the specified length
    private static StringBuilder initialStringBuilder(int a) {
        StringBuilder sb = new StringBuilder(a);

        for (int i = 1; i <= a; i++){
            sb.append("*");
        }
        return sb;
    }
}