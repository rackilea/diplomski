byte[] byteArray = IOUtils.toByteArray(stream);     
    InputStream input1 = new ByteArrayInputStream(byteArray);
    InputStream input2 = new ByteArrayInputStream(byteArray);

    Object body;
    try {
        ObjectInput ois = new ObjectInputStream(input1);
        body = ois.readObject();
    } catch (Exception e) {
        try {
            body = IOUtils.toString(input2, Charset.forName("UTF-8"));
       } catch (Exception e2) {
            throw new MarshalException("Could not convert inputStream");
        }
    }