Scanner in=new Scanner(System.in);
System.out.println("Enter the Drive name like C,D,E etc");
String drive=in.next();
System.out.println("Enter the main folder name");
String main_folder=in.next();
File directory=new File(drive+":"+"//"+main_folder+"//");