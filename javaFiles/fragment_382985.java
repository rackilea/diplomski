File xml = new File("xmlpath");

String url = xml.getAbsolutePath();
url = url.replace('\\', '/');
url = url.replace(" ", "%20");

String actual = "file:/" + url;

selenium.open(actual);