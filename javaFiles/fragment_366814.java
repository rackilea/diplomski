public void writeAllProperties( HashMap<String, String> newProps ) throws IOException {
    // fileOut = new BufferedWriter( new FileWriter( config ) );
    HashMap<String, String> props = loadAllProperties();
    props.putAll( newProps );
    config.delete();
    config.createNewFile();
    config.setWritable( true );
    // You just created a new file.
    fileOut = new BufferedWriter( new FileWriter( config ) );