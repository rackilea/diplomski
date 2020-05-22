private static XML noBOM(String path, PApplet p) throws 
            FileNotFoundException, UnsupportedEncodingException, IOException{

        //set default encoding
        String defaultEncoding = "UTF-8";

        //create BOMInputStream to get rid of any Byte Order Mark
        BOMInputStream bomIn = new BOMInputStream(new FileInputStream(path));

        //If BOM is present, determine encoding. If not, use UTF-8
        ByteOrderMark bom = bomIn.getBOM();
        String charSet = bom == null ? defaultEncoding : bom.getCharsetName();

        //get buffered reader for speed
        InputStreamReader reader = new InputStreamReader(bomIn, charSet);
        BufferedReader breader = new BufferedReader(reader);

        //Build string to parse into XML using Processing's PApplet.parsXML
        StringBuilder buildXML = new StringBuilder();
        int c;
        while((c = breader.read()) != -1){
            buildXML.append((char) c);
        }
        reader.close();
        return p.parseXML(buildXML.toString());
    }