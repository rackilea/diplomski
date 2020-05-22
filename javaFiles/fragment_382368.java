fun getPackageNameFromXml(s: String): String {
    try {
        val xmlFactoryObject = XmlPullParserFactory.newInstance()
        val myParser = xmlFactoryObject.newPullParser()
        myParser.setInput(StringReader(s))
        var event = myParser.eventType
        while (event != XmlPullParser.END_DOCUMENT) {
            val name = myParser.name
            when (event) {
                XmlPullParser.START_TAG -> {
                    if (name.toLowerCase() == "manifest") {
                        val packageName = myParser.getAttributeValue(null, "package")
                        if (packageName != null) {
                            return packageName
                        }
                    }
                }

                XmlPullParser.END_TAG -> {

                    }
            }
            event = myParser.next()
        }
    } catch (e: XmlPullParserException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return ""
}