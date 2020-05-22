public class array
{

   public static void main(String[] args) throws IOException
   {

      BufferedReader reader = new BufferedReader(new FileReader("fruit.txt"));

      System.out.println("enter the fruit you want to search");
      Scanner input = new Scanner(System.in);
      String fruit = input.nextLine();

      String line;

      boolean found = false;
      int count = 0;

      List<String> list = new ArrayList<String>();
      while ((line = reader.readLine()) != null)
      {
         String[] items = line.split(" ");

         if (fruit.equals(items[0]))
         {
            found = true;
            count = Integer.parseInt(items[1]);
            break;
         }

         list.add(line);
      }

      reader.close();

      if (found)
      {
         System.out.println("You have " + fruit + " " + count + " of them and status is good");
      }
   }
}