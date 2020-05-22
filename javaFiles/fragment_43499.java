public class Demo {
           public static void main(String []args) {
              String str = "aaabbbaaa";
              String a ="a";
              int counta = 0;

          System.out.println("String: "+str);
          for (int i = 0; i < str.length(); i++) {
             if (str.charAt(i) == a.charAt(0)){
                 counta++;  }  }

              {for(int counter=0; counter < counta; counter++) 
                    System.out.print(a); } }  }