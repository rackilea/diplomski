import java.text.SimpleDateFormat;
import java.util.StringTokenizer;


class FormatNames
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "john m smith 12121993 paul bright 1111882. ";
        StringTokenizer st= new StringTokenizer(s, " .");   


        SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");


        while(st.hasMoreTokens()) 
        {
            String string1= st.nextToken();
            Integer date = null;
            try
            {
                date = Integer.parseInt(string1);

            }
            catch (Exception e)
            {

            }
            if (date != null)
            {
                String formattedDate = newFormat.format(date);
                System.out.print(formattedDate);
            }
            else
            {
                System.out.print(string1);
            }
            System.out.print(" ");
        }
    }
}