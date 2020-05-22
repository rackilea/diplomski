String json =
        "{\n" +
        "    \"1\": {\n" +
        "        \"link\": \"http://www.hfk-bremen.de/t/meisterkurse/n/4-historic-brass-studio\",\n" +
        "        \"title\": \"4. Historic Brass Studio\",\n" +
        "        \"content\": \"Vom 13. bis 16. März 2013 findet das 4. Historic Brass Studio Bremen an der Hochschule für Künste Bremen statt. Angeboten an den vier Tage authentische historische Spielpraxis für Trompete, Posaune, Zink und Horn:\",\n" +
        "        \"img\": \"http:\n" +
        "        //www.hfk-bremen.de/sites/default/files/imagecache/event_block_thumb_300w/media/historicbrassstudio_1.jpg\",\n" +
        "        \"type\": \"concerts\"\n" +
        "    },\n" +
        "    \"2\": {\n" +
        "        \"link\": \"http://www.hfk-bremen.de/t/konzerte/n/orgelkonzert-3\",\n" +
        "        \"title\": \"Orgelkonzert\",\n" +
        "        \"content\": \"Studierende der Orgeklassen von KMD Prof. Tilmann Benfer spielen die Choralbearbeitungen von Brahms und Kluge am 14.03.2013 im St. Petri Dom Bremen.\",\n" +
        "        \"img\": \"http://www.hfk-bremen.de/sites/default/files/imagecache/content_start/imagegeneration/Orgelkonzert.png\",\n" +
        "        \"type\": \"concerts\"\n" +
        "    },\n" +
        "    \"3\": {\n" +
        "        \"link\": \"http://www.hfk-bremen.de/t/konzerte/n/musik-im-museum-6\",\n" +
        "        \"title\": \"Musik im Museum\",\n" +
        "        \"content\": \"Konzert mit Clovis Michon (Violoncello) aus der Klasse von Prof. Alexander Baillie am 14.03.2012 um 19.30 Uhr. Auf dem Programm stehen die Solo-Suiten von J.S. Bach No. 1-3, BWV 1007-1009\",\n" +
        "        \"img\": \"http://www.hfk-bremen.de/sites/default/files/imagecache/event_block_thumb_300w/media/musikimmuseum_8.jpg\",\n" +
        "        \"type\": \"concerts\"\n" +
        "    }\n" +
        "}";

Gson gson = new Gson();

Map map = gson.fromJson(json, Map.class);

System.out.println(((Map)map.get("2")).get("title"));