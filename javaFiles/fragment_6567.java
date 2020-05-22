if(rs.next()){
        rs.absolute(2);
        FirstName2.setText(rs.getString("cFirstname"));
        LastName2.setText(rs.getString("CLastname"));
        MiddleName2.setText(rs.getString("cmiddlename"));
            if(rs.getBinaryStream("cimage")!=null){
            BufferedImage im2 = ImageIO.read(rs.getBinaryStream("cimage"));
            ImageIcon image2 = new ImageIcon(im2);
            Image img2 = image2.getImage();
            Image newImage2 = img2.getScaledInstance(144, 144, Image.SCALE_SMOOTH);
            ImageIcon after2 = new ImageIcon(newImage2);
        btnPic2.setIcon(after2);
        btnPic2.setText("");}
            else{
            btnPic2.setText("No Picture");     
            }
        FirstName2.setVisible(true);
        LastName2.setVisible(true);
        btnPic2.setVisible(true);
        MiddleName2.setVisible(true);
        }