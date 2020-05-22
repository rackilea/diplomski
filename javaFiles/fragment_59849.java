Statement s;
         Connection c;      
         FileInputStream fis;
         PreparedStatement ps;
         File file; 
         try
        {
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//your driver
               c=DriverManager.getConnection("Jdbc:Odbc:image","scott","tiger");//password and name changes according to your db
               s=c.createStatement();   
               st.execute("Create table ImageStoring(Image_No number(5),Photo blob)");
         }
         catch(Exception e1) 
        {
               e1.printStackTrace();
         }  

         try
        {       
               file=new File"D:/ARU/Aruphotos/4.jpg");
               fis=new FileInputStream(file);

               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               c=DriverManager.getConnection("Jdbc:Odbc:image","scott","tiger");
               s=c.createStatement();

               ps=c.prepareStatement("insert into ImageStoring values(?,?)");
               ps.setInt(1,2);
               ps.setBinaryStream(2,fis,(int)file.length());
               System.out.println("success");
               ps.execute();
               ps.close();
               c.close();
         }
         catch(Exception e)
         {
               e.printStackTrace();
         }
     }