public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
      int c = 0 ;
    int num = input.nextInt();
    input.close();
    while (c < num)
    {
        c++;
   System.out.println(String.format("%"+c+"s",c)); 
    }
}