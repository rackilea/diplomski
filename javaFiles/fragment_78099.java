public static void main(String[] args)
      {
          String str = "baby";
            for (int i = 1; i <= str.length(); i +=2) {
                if(i<str.length())
                   System.out.print(str.charAt(i));
                System.out.print(str.charAt(i-1));
              }
      }