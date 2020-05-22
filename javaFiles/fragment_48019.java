DataInputStream dis = new DataInputStream(new FileInputStream(f));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[dis.available()];

        while ((nRead = dis.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dataOutStream = new DataOutputStream(baos);
        dataOutStream.write(data);

        OutputStream outputStream = new FileOutputStream("newFilePath");
        baos.writeTo(outputStream);
        baos.close(); //Lets close some streams 
        dataOutStream.close();
        outputStream.close();
        buffer.close();
        dis.close();