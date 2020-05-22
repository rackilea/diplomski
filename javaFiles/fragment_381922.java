int i = 0;
String[] name = new String[3];
int[] age = new int[3];
do {
   System.out.print("Enter a name ");
   name[i] = scanner.nextLine();

   System.out.print("Enter age ");
   age[i] = Integer.parseInteger(input.nextLine());
   ;
   i++;
} while (i <= 3);