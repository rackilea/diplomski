enum s {FIRST, SECOND} //add this

public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String text = giveMe(s.FIRST); //add the s. so it knows to use your enum
    System.out.println(text);
    int x = scanner.nextInt();
    x = number(x);
    skrivUt(x);
}