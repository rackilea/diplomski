java.sql.Statement st=connection.createStatement();
   ResultSet rs=st.executeQuery("SELECT ApplicationId FROM application");

    while(rs.next())
    {
        FileOutputStream fileOutputStream=null;
        Reader reader=null;
        try {
            fileOutputStream =   new FileOutputStream("output.txt");
            reader=rs.getNCharacterStream(1 /*you can use here column name also*/);
            int c;
            while( (c=reader.read())!=-1)
            {
                fileOutputStream.write(c) ;
            }

        }           
        catch(Exception e){}
        finally {
            if (reader != null) {
                reader.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }