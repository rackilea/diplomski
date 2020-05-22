class GroupOfFourInts
{
   int myInt1;
   int myInt2;
   int myInt3;
   int myInt4;

   public GroupOfFourInts(int a, int b, int c, int d)
   {
     myInt1 = a; myInt2 = b; myInt3 = c; myInt4 = d;
   }
}

class someOtherClass
{

  public static void main(String[] args)
  {
    LinkedList<GroupOfFourInts> linky = new LinkedList<GroupOfFourInts>();
    GroupOfFourInts group1 = new GroupOfFourInts(1,2,3,4);
    GroupOfFourInts group2 = new GroupOfFourInts(1337,7331,2345,6789);
    linky.add(group1);
    linky.add(group2);
  }
}