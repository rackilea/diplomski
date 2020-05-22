String xml = "<IOStatusSummary><iostatus_interval_value><count>0</count><iostatusvalue datainterval=\"2016-01-16 15:45:30\">1.0</iostatusvalue><iostatusvalue datainterval=\"2016-01-16 19:47:29\">0.0</iostatusvalue><iostatusvalue datainterval=\"2016-05-16 13:01:07\">1.0</iostatusvalue><iostatusvalue datainterval=\"2016-05-16 18:51:33\">0.0</iostatusvalue><iostatusvalue datainterval=\"2016-05-27 16:45:50\">1.0</iostatusvalue><iostatusvalue datainterval=\"2016-05-27 20:56:00\">0.0</iostatusvalue><iostatusvalue datainterval=\"2016-06-10 10:21:28\">1.0</iostatusvalue><iostatusvalue datainterval=\"2016-06-10 20:01:17\">0.0</iostatusvalue></iostatus_interval_value></IOStatusSummary>";
    ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
    DocumentBuilder db1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc1 = db1.parse(bais);

    NodeList nList_interval = doc1.getElementsByTagName("iostatus_interval_value").item(0).getChildNodes();

    List<String> on = new ArrayList<String>();
    List<String> off = new ArrayList<String>();

    for (int i = 0; i < nList_interval.getLength(); i++) {
        Element element = (Element) nList_interval.item(i);
        if (element.getTagName().equals("iostatusvalue")) {
            String text = element.getTextContent();
            String interval = element.getAttribute("datainterval");
            if (text.equals("1.0")) {
                on.add(interval);
            }
            if (text.equals("0.0")) {
                off.add(interval);
            }
        }
    }
    System.out.println(on);
    System.out.println(off);