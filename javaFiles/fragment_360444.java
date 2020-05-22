public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    String s;
    System.out.println("Enter a line:");
    s=in.nextLine();
    int ct=0;
    for(String str: s.split(" ")) {
        if(str.charAt(0)>=65 && str.charAt(0)<=90)
        {
            ct++;

        }
    }
    System.out.println("total  number of words start with capital letters are :"+ct);
}