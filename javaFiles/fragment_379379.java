public class CharExp {
    private static String final_output="";
    public static void charCount(String [] a){
        String chc="" ;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                char ch = a[i].charAt(j);
                int charcout = a[i].length();
                chc=  Character.toString(ch)+""+Integer.toString(charcout)+" ";
                final_output += chc + " ";
            }
        }
    } 

    public static void main(String[] args) 
    {
        String [] stringlist= {"1h","xa yb","2h","xax yk zn","3h","5h","6h","2h"};
        for (String string : stringlist) 
        {
            String[] splitted_list = string.split(" ");
            if((splitted_list[0].charAt(0)=='1')
            ||(splitted_list[0].charAt(0)=='2') 
            ||(splitted_list[0].charAt(0)=='3')  
            ||(splitted_list[0].charAt(0)=='4')  
            ||(splitted_list[0].charAt(0)=='5')  
            ||(splitted_list[0].charAt(0)=='6')  
            ||(splitted_list[0].charAt(0)=='7'))  
            {
                String ra1 = splitted_list[0].replaceAll("1", "v");
                ra1 = ra1.replaceAll("2", "t");
                ra1 = ra1.replaceAll("3", "t3");
                ra1 = ra1.replaceAll("4", "f");
                ra1 = ra1.replaceAll("5", "f5");
                ra1 = ra1.replaceAll("6", "s");
                final_output += ra1 + " ";
            } 
            else 
            {
                charCount(splitted_list);
            }
        }
        System.out.print(final_output);
    }
}