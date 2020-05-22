String zip = "...";
String url = "http://gateway.moviefone.com/movies/pox/closesttheaters.xml?zip=" + zip;

// read and parse the xml
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document = builder.parse(url);

//get elements you need
NodeList list = document.getElementsByTagName("closestTheatersUrl");
String urlForTheater = list.item(0).getNodeValue();