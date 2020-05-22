OutputStream os = fs.create( "/filelocation/input.txt",  new Progressable() {
    public void progress() {

    }
 });
BufferedWriter br = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
br.write(extractedXML);
br.close();