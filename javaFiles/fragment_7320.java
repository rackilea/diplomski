Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
int len=sc.nextInt();
for(int i=0;i<=s.length() - len;i++) {
    System.out.println(s.substring(i,i+len));
}