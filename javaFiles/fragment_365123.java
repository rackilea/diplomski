public class FileReaderExample
{
  public static void main(String[] args)
  {
    File file = new File("d:\\text.txt");
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line;
      int lineNo = 1;
      while ((line = br.readLine()) != null)
      {
        // ignore the first line of       Date    Opening    Closing
        if (lineNo != 1)
        {
          String[] itemsOnLine = line.trim().split("\\s+");
          System.out.println("Your date is : " + itemsOnLine[0]);
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
          Date yourDate = simpleDateFormat.parse( itemsOnLine[0]);
          System.out.println(yourDate);
          Calendar calendar= Calendar.getInstance();
          calendar.setTime(yourDate);
          // Account for month starting at 0
          int month = calendar.get(Calendar.MONTH) +1 ;
          System.out.println("The month of the date is " + month);
        }
        lineNo++;
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
  }
}