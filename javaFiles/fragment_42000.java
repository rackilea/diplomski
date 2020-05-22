public void toJsonFile(String jsonFileName) {

    JSONObject jsonObj = new JSONObject();
    FileWriter out = null;

    try{
        for(int i = 0; i < movieLib.size(); i++)
            jsonObj.put(movieLib.get(i).getTitle(),movieLib.get(i).toJSONObject());
        out = new FileWriter(jsonFileName);
        out.write(jsonObj.toString());
        out.close();
    }
    catch(Exception e){
        e.printStackTrace();
        if(out != null){
            try{
            out.close();
            }
            catch(IOException z){
                z.printStackTrace();
                System.exit(0);
            }
        }
    }
}