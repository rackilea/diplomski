public static void main (String[] args) throws java.lang.Exception
{
    Pattern p = Pattern.compile( "((\\w+)\\s*(\\d{1,2})\\s*(\\d{4}))|((\\d{1,2})\\/(\\d{1,2})\\/(\\d{4}))" );
    String input_1 = "July 4 1776 was bla bla";
    String input_2 = "02/25/2016";
    Matcher m = p.matcher( input_1 );
    String month = null;
    String day = null;
    String year = null;
    String formatted_date = null;
    if( m.find() )
    {
        System.out.println("Found groups :" + m.group() );
        String found = m.group();
        if( found.matches("((\\d{1,2})\\/(\\d{1,2})\\/(\\d{4}))") )
        {
            p = Pattern.compile("(\\d{1,2})\\/(\\d{1,2})\\/(\\d{4})");
            m = p.matcher(found);
            if( m.find() )
            {
               month = m.group(1);
               day = m.group(2);
               year = m.group(3);
               String formatteddate =  year + "_" + day + "_" + month;
               System.out.println(input_1.replaceAll("((\\d{1,2})\\/(\\d{1,2})\\/(\\d{4}))", formatteddate));
            }

        }
        else if( found.matches("((\\w+)\\s*(\\d{1,2})\\s*(\\d{4}))") )
        {
            p = Pattern.compile("(\\w+)\\s*(\\d{1,2})\\s*(\\d{4})");
            m = p.matcher(found);
            if( m.find() )
            {
               month = m.group(1);
               day = m.group(2);
               year = m.group(3);
               String formatteddate =  year + "_" + day + "_" + month;
               System.out.println(input_1.replaceAll("((\\w+)\\s*(\\d{1,2})\\s*(\\d{4}))", formatteddate));
            }


        }


    }
    else
    {
        System.out.println("No groups found");
    }
}

public static boolean isInteger(String s) 
{
   try 
   { 
     Integer.parseInt(s); 
   } catch(NumberFormatException e) 
   { 
     return false; 
   } catch(NullPointerException e) 
   {
     return false;
   }

   return true;
}