Map<String, List<String>> currentMap = new HashMap<String, List<String>>();
List<Map> listOfHash = new ArrayList<Map>();
listOfHash.add(currentMap);


for (int temp = 0; temp < nList.getLength(); temp++) {
    Node nNode = nList.item(temp);
    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;
        String word = getTagValue("word", eElement);    

        if ("000000000".equals(word)){
            currentMap = new HashMap<String, List<String>>();
            listOfHash.add(currentMap);
            continue; // if we wan't to skip the insertion of "000000000"
        }

        String pos = getTagValue("POS", eElement);

        List<String> add_word = currentMap.get(pos);
        if(add_word==null){
            add_word = new ArrayList<String>();
            currentMap.put(pos, add_word);
        }
        add_word.add(word);
    }

}