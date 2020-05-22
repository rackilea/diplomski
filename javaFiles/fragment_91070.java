Scanner in = new Scanner(System.in);
String[] groupName = new String[1];
System.out.print("Group Name: ");
groupName[0] = in.nextLine();
System.out.print("Names: ");
String names = in.nextLine();
String[] members = names.split(",");
System.out.println(Arrays.toString(members));
in.close();