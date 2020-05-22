//File in assets folder
        InputStream tinstr = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            AssetManager assetManager = getAssets();
            tinstr = assetManager.open("test.xml");
            parser.setInput(new InputStreamReader(tinstr));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }