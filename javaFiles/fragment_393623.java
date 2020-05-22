private String execute(String[] command){
    //System.out.println(command);
    try{
        process = Runtime.getRuntime().exec(command);
        InputStream istream = process.getInputStream();
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        Reader reader = new BufferedReader(new InputStreamReader( istream ));
        int n;
        while ((n = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, n);
        }
        reader.close();
        istream.close();
        return writer.toString();
    }
    catch ( IOException e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return "";
}