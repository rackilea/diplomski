File f = new File(Address);
    FileReader r = new FileReader(f);
    BufferedReader b = new BufferedReader(r);
    String out = "";
    String k="";
    while( (out=b.readLine()) != null) {
        k+=out;
    }
    b.close();