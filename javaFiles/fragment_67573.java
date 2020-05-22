if(e.getSource() == reset) {    
    Properties props = new Properties();
    InputStream in = new  FileInputStream("oop.txt")
    props.load(in);
    in.close();

    //you can now access existing user name and password using proper.getProperty(key);

    //update to new details
    props.setProperty("user", inputUser);
    props.setProperty("password", inputPass);

    OutputStream out = new FileOutputStream("oop.txt");
    props.store(out, null);
    out.flush();
    out.close();

 }