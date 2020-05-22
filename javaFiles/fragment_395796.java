try
        {
          SAXParserFactory factory = SAXParserFactory.newInstance();
          SAXParser saxParser = factory.newSAXParser();
          InputStream is = null;

          String xml = "your pasable string";

          String newXml = xml.substring(xml.indexOf("<translation>"), xml.indexOf("]]"));         
          System.out.println(newXml);
          is = new ByteArrayInputStream(newXml.getBytes());
          InputSource inputSource = new InputSource(is);
          saxParser.parse(inputSource,new xmlHandler());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }