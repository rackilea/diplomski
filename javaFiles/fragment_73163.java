Iterator<Map.Entry<String,JsonNode>> iter = jsonNode.fields();
while ( iter.hasNext() ) {

     Map.Entry<String,JsonNode> currentEntry = iter.next();
     map.put(currentEntry.getKey(), currentEntry.getObject());

}