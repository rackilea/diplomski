public void criarArq(Context mcoContext,  String fileName, String body) {
    File file = new File(mcoContext.getFilesDir(),"mydir");
    file.mkdirs(); //no need to check exists with mkdirs

    File gpxfile = new File(file, fileName);
    try {
        FileWriter writer = new FileWriter(gpxfile);
        writer.append(body);
        writer.flush();
        writer.close();
    } catch (IOException e) {
        //Don't eat the exception, do something with it, e.g.
        Log.e("criarArq", e.toString()); //this will give you your error in the log cat
        throw new RuntimeException(e); //this will bomb your program out for when the error is unrecoverable
    }
}