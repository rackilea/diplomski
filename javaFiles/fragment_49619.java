public class Title {
    public static void main(String args[]) {
        String rev = "This is a boy";
        String []a = rev.split(" ");

        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length-1)
                System.out.print(a[i]);
            else
                System.out.print(" "+a[i]);
        }
    }
}