public class Title {
    public static void main(String args[]) {
        String rev = "This is a boy";
        char a[] = new char[rev.length()];
        int i, j;
        int index =0;
        int previous = a.length;
        for (i = a.length - 1; i >= 0; i--) {
            if (rev.charAt(i) == ' ' ) {
                for (j = i + 1; j < previous; j++) {
                    a[index] = rev.charAt(j);
                    index ++;
                }
                a[index++] = ' ';
                previous = i;
            }
        }
        for (j = 0; j < previous; j++) {
            a[index] = rev.charAt(j);
            index ++;
        }
        String n = new String(a);
        System.out.print(n);
    }
}