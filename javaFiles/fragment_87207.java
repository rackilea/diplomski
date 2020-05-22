String sql = " INSERT INTO TABLE_(name,email,phone,id) VALUES(?,?,?,?) ";


try { 
        BufferedReader bReader = new BufferedReader(new FileReader("1000rows.csv"));
        String line = ""; 
        while ((line = bReader.readLine()) != null) {
            try {

                if (line != null) 
                {
                    String[] array = line.split(",+");
                    for(String result:array)
                    {
                        System.out.println(result);
 //Create preparedStatement here and set them and excute them
                PreparedStatement ps = yourConnecionObject.createPreparedStatement(sql);
                 ps.setString(1,str[0]);
                 ps.setString(2,str[1]);
                 ps.setString(3,str[2]);
                 ps.setString(4,strp[3])
                 ps.excuteUpdate();
                 ps. close()
   //Assuming that your line from file after split will folllow that sequence

                    }
                } 
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            finally
            {
               if (bReader == null) 
                {
                    bReader.close();
                }
            }
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }