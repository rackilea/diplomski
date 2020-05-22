Scanner input = new Scanner(System.in);
String postfix = input.nextLine();
char[] charArray = postfix.replace(" ", "").toCharArray();
Node root = constructTree(charArray);
System.out.println("infix expression is");
System.out.println(root);