Elements script = doc.select("script");
Pattern p = Pattern.compile("xmlhttp.open\\(\"GET\", \"(.*)\", false\\)");
                                                    //  ^^ is the capturing group
String url = "";

for (Element element : script) {
    Matcher m = p.matcher(element.data());
    if (m.find()){
        url = m.group(1);
    }
}
System.out.println(url); //-> http://...542988