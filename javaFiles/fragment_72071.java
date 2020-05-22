public void getSavedImages(){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:image");
            PreparedStatement pstm1 = con.prepareStatement("select * from image");
            ResultSet rs1 = pstm1.executeQuery();
            while(rs1.next()) {
                InputStream fis1;
                FileOutputStream fos;
                String image_id;
                try {
                    fis1 = rs1.getBinaryStream("image");
                    image_id=rs1.getString("image_id");
                    fos = new FileOutputStream(new File(Path to "C:\\" + (image_id) + "Your Extension(.jpg/.gif)"));
                    int c;
                    while ((c = fis1.read()) != -1) {
                        fos.write(c);
                    }
                    fis1.close();
                    fos.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } 
            pstm1.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Exception Occured:"+ex);
        }
    }