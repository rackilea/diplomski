public static void main(final String[] args)
{
    final String data = "1,Helen,Dobre,Lesson1,Lesson2";
    final String[] row = data.split(",");
    final int c1 = Integer.parseInt(row[0]);
    System.out.println("c1 = " + c1);
}