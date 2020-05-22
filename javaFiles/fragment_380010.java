AssetManager assetManager = getAssets();
InputStream is = assetManager.open("infofermata.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(is);
[...]
is.close();