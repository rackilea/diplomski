public static void write(FileOutputStream outfile, String s) {
    try {
      for(int i = 0; i < s.length(); i++)
        outfile.write(s.charAt(i));
      outfile.write(13); outfile.write(10);
    } catch (IOException ex) {JOptionPane.showMessageDialog(null, ex);}
  } 

  public static Scanner openDic(){
    InputStream myStream = null;
    try { myStream =  Class.forName("masterwords.Masterwords").getClassLoader()
                      .getResourceAsStream("dictionary"); 
    }catch (ClassNotFoundException ex) {/* ... */}
    return new Scanner(myStream).useDelimiter("\r");
  }

  public static void createDictionaryIfNecessary(){

    Path out_path = FileSystems.getDefault().getPath(DICTIONARY);

    if(Files.exists(out_path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) return;

    FileOutputStream outStream = null;
    try {outStream = new FileOutputStream(out_path.toFile());} 
    catch (FileNotFoundException ex) {JOptionPane.showMessageDialog(null,ex);}

    Scanner scInternalDic = IO.openDic();
    while(scInternalDic.hasNext()){
      Utilities.write(outStream,scInternalDic.next());
    }

    try {outStream.close();} 
    catch (IOException ex) {JOptionPane.showMessageDialog(null,ex);}
    scInternalDic.close();
  }