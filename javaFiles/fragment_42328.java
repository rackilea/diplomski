while (rs.next()) 
            {
                Blob image_blob=rs.getBlob("image_100x100");
                int blobLength = (int) image_blob.length(); 
                byte[] blobAsBytes = image_blob.getBytes(1, blobLength); 
                InputStream in=new ByteArrayInputStream( blobAsBytes );
                BufferedImage image_bf = ImageIO.read(in); 
                ImageIO.write(image_bf, "PNG", new File(folder_path+"/"+rs.getString("name"))); 
            }