Iterator<Map.Entry<String, JsonNode>> fieldIterator = testNode.
while (fieldIterator.hasNext()) 
{
   Map.Entry<String, JsonNode> entry = fieldIterator.next();
   if (entry.getValue().isArray())
   {
      ArrayNode arrayNode = (ArrayNode) entry.getValue();
      for(int i = arrayNode.size()-1; i >= 0 ; i--)
      {
         if(arrayNode.get(i).path("form2").isMissingNode())
            arrayNode.remove(i);

     }
   }
}