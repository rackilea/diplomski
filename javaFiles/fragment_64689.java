ByteArrayInputStream bai = new ByteArrayInputStream(pByte);
        ContentHandler contenthandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        try {
              parser.parse(bai, contenthandler, metadata);

        } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        } catch (SAXException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        } catch (TikaException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }           
        System.out.println("Mime: " + metadata.get(Metadata.CONTENT_TYPE));
        return metadata.get(Metadata.CONTENT_TYPE);