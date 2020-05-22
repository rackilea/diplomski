AssetManager assetManager = getResources().getAssets();
InputStream inputStream = assetManager.open("MyFile.txt");
//to get the content of the file as String
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
StringBuilder out = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) {
     out.append(line);
}
String myString=out.toString();
reader.close();