String request = "http://ws.audioscrobbler.com/2.0/?method=" + method +
                    "&api_key="+apiKey;
            request += "&artist=" + artist.replaceAll(" ", "%20");
            if (method.equals("album.getinfo")) request += "&album=" + album.replaceAll(" ", "%20");
            URL url = new URL(request);
            InputStream is = url.openStream();
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(is);

            NodeList nl = doc.getElementsByTagName("image");
            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                if (n.getAttributes().item(0).getNodeValue().equals(imageSize)) {
                    Node fc = n.getFirstChild();
                    if (fc == null) return null;
                    String imgUrl = fc.getNodeValue();
                    if (imgUrl.trim().length() == 0) return null;
                    return new ImageIcon(new URL(imgUrl));
                }
            }