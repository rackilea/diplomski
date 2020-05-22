XmlReader xml = new XmlReader();
    try {
        // Element is the root element of your document, i.e. <levels>
        XmlReader.Element element = xml.parse(Gdx.files.internal("D:\\someFolder\\android\\assets\\levels.xml"));
        currentLevel = element.getInt("currentLevel");
        XmlReader.Element level = element.getChildByName("Level1");
        lineAngle = level.getInt("lineAngle");
        speed = level.getFloat("speed");
        direction = level.getInt("direction");
    } catch (Exception e) {
    }