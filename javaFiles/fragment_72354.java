// create a Document from inputstream is
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(is);

// fetch the feed
SyndFeedInput input = new SyndFeedInput();
SyndFeed feed = input.build(doc);