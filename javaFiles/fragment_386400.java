public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Exactly how many inches are you?  ");
    int uHeight = in.nextInt();

    System.out.println("He's " + uHeight + " inches or " + inchesToCm(uHeight) + " cm.");
    System.out.print("How many inches is your mother? ");

    int mHeight = in.nextInt();
    System.out.println("He's " + mHeight + " inches or " + inchesToCm(mHeight) + " cm.");
    //------------------------------^^-------------------------------^^------------------
    in.close();//close your Scanner
}

//Your function should take inches and return cm
public static double inchesToCm(int height) {
    return height * 2.54;
}