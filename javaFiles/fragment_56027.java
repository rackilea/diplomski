public static void main(final String[] args)
{
   StudentInfo si = new StudentInfo();
   si.insertAscending(2, "Brent", 23, 2.2);
   //si.insertAscending(3, "Steve", 23, 2.2);
   //si.insertAscending(5, "Joe", 23, 2.2);
   //si.insertAscending(4, "Pat", 23, 2.2);
   //si.insertAscending(1, "Mike", 23, 2.2);
   si.print();
   System.out.println("==========");
   si.printReverse();
}