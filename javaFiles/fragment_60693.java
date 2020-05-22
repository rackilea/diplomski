HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(int i = 0; i < nl.getLength(); i++) {
             String name = (Element) nl.item(i)).getAttribute("name");
             populateMap(map, name, KEY_TITLE);
            for(int j = 0; j < nl1.getLength(); j++) {
                String title=(Element) nl1.item(j)).getAttribute("title");
                populateMap(map, title, KEY_ARTICLE);

                String url=(Element) nl2.item(j)).getAttribute("url");
                populateMap(map, url, KEY_IMAGE);
            }
            songsList.add(map);
        }