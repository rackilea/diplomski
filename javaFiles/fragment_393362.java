String jsonfile="{ \"name\" : \"Raj\", \"Address\" : \"Chennai\", \"images\": { \"jpg\" : \"JPEG file\", \"png\" : \"PNG File\", \"gif\" : \"GIF file\" }}";

    JSONObject jobject = new JSONObject();
    JSONParser jparser = new JSONParser();

    //Convert your string jsonfile into a JSONObject   
    try {
        jobject = (JSONObject) jparser.parse(jsonfile);
    } catch (ParseException ex) {
        Logger.getLogger(Josimarleewords.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.println(jobject.toString());    
    //{"Address":"Chennai","name":"Raj","images":{"jpg":"JPEG file","png":"PNG File","gif":"GIF file"}}

    //Get the node image, and convert it into a JSONObject
    //You're able to do so, because the value associated to "images"
    //is in json format.
    jobject=(JSONObject) jobject.get("images");
    System.out.println(jobject.toString()); 
    //{"jpg":"JPEG file","png":"PNG File","gif":"GIF file"}

    //Retrieves the value associated to the key jpg.
    //The value here is not in json format, it is a simple string
    String jpg = (String)jobject.get("jpg");                 
    System.out.println(jpg.toString());
    //JPEG file