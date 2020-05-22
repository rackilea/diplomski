private void downloadAndStoreJson(String url,String tag){

        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);          

        String jsonString = json.toString();                
        byte[] jsonArray = jsonString.getBytes();

        File fileToSaveJson = new File("/sdcard/appData/LocalJson/",tag);



        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(fileToSaveJson));
            bos.write(jsonArray);
            bos.flush();
            bos.close();

        } catch (FileNotFoundException e4) {
            // TODO Auto-generated catch block
            e4.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            jsonArray=null;
            jParser=null;
            System.gc();
        }

  }