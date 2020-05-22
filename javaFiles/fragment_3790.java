public void filereader (){
        String[] titles = {"first name: ", "last name: ", "gender" ,"age","address","id"};
        int i=0;
        Object[] options = {"OK"};
        try
        {
        FileInputStream in = new FileInputStream("records.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        StringBuffer sb = new StringBuffer();

        while((strLine = br.readLine())!= null)
       {
        sb.append(titles[i]+ strLine +"\n");
              if (i == 5) { 
                   i=0;
               } else
               { i++; };
                 }
              JOptionPane.showMessageDialog( null, sb.toString());
               }catch(Exception e){
              JOptionPane.showOptionDialog(null, "Error", "Customers",   JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }

             }