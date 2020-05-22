AssetManager assets = getAssets();

try {
  InputStream in = assets.open("list.txt");
  LineNumberReader lin = new LineNumberReader(new InputStreamReader(in));
  String line;
  while((line = lin.readLine()) != null) {
    Log.i(TAG, "read a line: " + line);
  }
} catch (IOException e) {
  Log.e(TAG, "Error reading assets!", e);
}