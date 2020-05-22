import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Scanner;

    public class Test4 {

    public static void main(String[] args) 
    {
    // TODO Auto-generated method stub
    Scanner gaba = new Scanner( System.in ); 
    String variable;
    System.out.print("Enter String:");
    variable = gaba.nextLine();
    SeparateGaba(variable);

    }
   public static void SeparateGaba(String str) 
    {
    String Catch_num = "";
    String Catch_let = "";
    String upper="";
    String lower="";
    for (int i = 0; i < str.length(); i++) 
    {
           char a = str.charAt(i);
           if (Character.isDigit(a)) 
           {
                 Catch_num = Catch_num + a;
           } else 
           {
                 Catch_let = Catch_let + a;
           }     
    } 

    System.out.println("FIRST OUTPUT:"+Catch_num+Catch_let);

    for(int j=0;j <Catch_let.length();j++)
    {
         char x = Catch_let.charAt(j);
         if (Character.isUpperCase(x))
         {
                upper += x;
         }
         else 
         {
               lower += x;
         }
    }

    char[] num = Catch_num.toCharArray();
    Arrays.sort(num);
    String n =new String(num);

    char[] ordr = lower.toCharArray();
    Arrays.sort(ordr);
    String alfa1 =new String(ordr);

    char[] ord = upper.toCharArray();
    Arrays.sort(ord);
    String alfa =new String(ord);

    String t= alfa1 + alfa;

    char [] fin = t.toCharArray();
    Arrays.sort(fin);
    String fal = new String(fin);

    Character[] chars = new Character[fal.length()];
    for (int f=0; f < fal.length();f++)

        chars[f] = fal.charAt(f);

        Arrays.sort(chars, new Comparator<Character>()
        {
        public int compare(Character c1, Character c2)
        {
            int cmp = Character.compare(
                    Character.toLowerCase(c1.charValue()),
                    Character.toLowerCase(c2.charValue())
                );
            if (cmp != 0) return cmp;
            return Character.compare(c1.charValue(), c2.charValue());
        }
        });

        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) sb.append(c);
        fal = sb.toString();
        System.out.println("SECOND OUTPUT= "+n+fal);
       /*GABA come on let seeeeeeeee*/
        try
        {
        for(int i=0;i<n.length();i++)
        {
            char a= n.charAt(i);

            System.out.print(a);

            for(int j=0; j<fal.length();j++)//1
            {
                char b = fal.charAt(j);
                if(j>=i)
                {   
                System.out.print(b);
                    break;
                }
            }
            }

           }
           catch(Exception e)
         {
       System.out.println("Your letter length should match with char len");
        }

       }
      }


       Enter String:14a5Bc
       FIRST OUTPUT:145aBc
       SECOND OUTPUT= 145aBc
       THE out put i was looking for --->1a4B5c