public static Till loadTillXML() {
    try{
        XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("till.xml")));
        return (Till) decoder.readObject();     
    }
    catch(FileNotFoundException fNFE){
        System.out.println("Cannot find file");
        Till till=new Till();
        return till;
    }
}