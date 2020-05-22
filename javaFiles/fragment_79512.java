InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destination.getAbsolutePath());

        int byteRead = 0;
           byte[] buffer = new byte[8192];
           while ((byteRead = in.read(buffer, 0, 8192)) != -1){
               out.write(buffer, 0, byteRead);
            }