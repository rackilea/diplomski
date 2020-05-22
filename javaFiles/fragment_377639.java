AssetManager am = context.getAssets();     
InputStream is = am.open("text");       
BufferedReader in = new BufferedReader(new InputStreamReader(is));       
String inputLine;       
while ((inputLine = in.readLine()) != null)         
    System.out.println(inputLine);
in.close();