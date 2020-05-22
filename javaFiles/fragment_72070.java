public void saveImage(File file){
        try {
            String img_id=JOptionPane.showInputDialog("Enter Image ID");
            FileInputStream fis=null;
            String query="insert into image(image_id,image) values (?,?)";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:image");
            PreparedStatement pstm=con.prepareStatement(query);
            fis=new FileInputStream(file);
            pstm.setString(1, img_id);       
            pstm.setBinaryStream(2, (InputStream)fis, (int)file.length());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Image Successfully Uploaded to Database");
            pstm.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("Exception Occured: "+ex);
        }
    }