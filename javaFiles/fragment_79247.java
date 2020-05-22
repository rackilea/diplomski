List<Multimap<String, String>> sentenceList = new ArrayList<>();
for (String line: lines) {
   Multimap<String, String> aux = ArrayListMultimap.create();
   PosToken=new StringTokenizer(SAPosTagging.tagedReview[line]);
   while(PosToken.hasMoreTokens()) {
       // TODO ...
       strToken=PosToken.nextToken();
       // TODO, lets assume it is a noun
       aux.put("noun", strToken);
       // TODO, etc.
   }
  sentenceList.add(aux);
}