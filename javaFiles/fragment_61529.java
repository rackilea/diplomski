public class Test
{    
     private static ArrayList<String> JPGHeaders = new ArrayList<String>();
     private static ArrayList<String> JPGTrailers = new ArrayList<String>();
     private static ArrayList<String> entireTextFile = new ArrayList<String>();

     public static void main (String[] args)
     {
         Scanner scanner = new Scanner(new File("C:\\HexAnalyser\\HexDump\\fileTest.txt"));

         while (scanner.hasNextLine())
         {
             String line = scanner.nextLine();
             if(line.contains(Constants.JPGHEADER))
             {
                JPGHeaders.add(line);
             }

             if(line.contains(Constants.JPGTRAILER))
             {
                JPGTrailers.add(line);
             }
         }

     }
}