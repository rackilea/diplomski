public static void pemEncodeToFile(String filename, Object obj, char[] password) throws Exception{
    PEMWriter pw = new PEMWriter(new FileWriter(filename));
       if (password != null && password.length > 0) {
           pw.writeObject(obj, "DESEDE", password, new SecureRandom());
       } else {
           pw.writeObject(obj);
       }
       pw.flush();
       pw.close();
    }