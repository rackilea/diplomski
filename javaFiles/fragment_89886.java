import java.io.IOException;
    import java.util.ArrayList;

    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.select.Elements;

    public class test
    {

         static ArrayList<String> arr_shipping=new ArrayList<String>();
     public static void main(String args[]) throws IOException
      {
         try {
            Document  doc = Jsoup.connect("https://vts.mhpa.co.uk/main_movelistb.asp").timeout(600000).get(); 
             Elements tableRows = doc.select("table.dynlist tr:not(:eq(0))");

             tableRows.size();
                     for(int i = 0; i < 10; i++){
                               //tableRows.get(i);
              String  shippingList =tableRows.get(i).text() +"\n";

                   arr_shipping.add(shippingList);// add value to ArrayList
                   System.out.println(shippingList);
                 } 
              } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }      

       //  return arr_shipping;//<< return ArrayList from here

      }

    }