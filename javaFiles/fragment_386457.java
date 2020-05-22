import java.util.HashMap;

/**
 *
 * @author Sai-Karan
 */
public class App {

    //Function to return the substring for the second encoding method
    //Example 1 will return On, and 2 will return Tw ....etc
    public static String findstringmap(char c)
    {
        //Create a hashmap and add the key elements and the string definitions
      HashMap <Integer, String> hmap = new HashMap <Integer, String>();

       /*Adding elements to HashMap*/
      hmap.put(1, "One");
      hmap.put(2, "Two");
      hmap.put(3, "Three");
      hmap.put(4, "Four");
      hmap.put(5, "Five");
      hmap.put(6, "Six");
      hmap.put(7, "Seven");
      hmap.put(8, "Eight");
      hmap.put(9, "Nine");
      hmap.put(0, "Zero");

      /* Get values based on key*/
      int num_value = Character.getNumericValue(c);
      //convert to the numeric value
      String var = hmap.get(num_value);
      //get the substring
      String ret_str = var.substring(0, 2);
      return ret_str;
    }
    public static void main(String[] args) {
        // TODO code application logic here

        String l1 = "Orange juice is great! I drank 83,214 cups of it yesterday.";
        //String final contains the result
         String Final = "";
         String next = "";
        for(int i =0 ; i< l1.length(); i++)
        {
           //char c = l1.charAt(i);

            if (l1.charAt(i) == ' ')
            {
             next = " ";
            }
            else if (l1.charAt(i) == '!')
            {
             next = "!";
            }
            else if(l1.charAt(i) == ',')
            {
                next = ",";
            }
            else if(l1.charAt(i) == '.')
            {
                next = ".";
            }
            else if(!(Character.isDigit(l1.charAt(i))))
           {
           int val = l1.charAt(i);
           next = String.valueOf( (char) (val + 1));

           // System.out.println(next);
           }
           else if(Character.isDigit(l1.charAt(i)))
           {
               next = findstringmap(l1.charAt(i));

           }
           Final = Final + next;

        }
        System.out.println(Final);
    }

}