public static void main(String[] args) {

        String hello = "hello";
        Brute b = new Brute();
       System.out.println( b.addspace(1,hello));
    }

    String addspace(int i, String str)
    {       
        StringBuilder str1 = new StringBuilder();
            for(int j=0;j<i;j++)
            {
                str1.append(" ");
            }
            str1.append(str);           
            return str1.toString();         

    }