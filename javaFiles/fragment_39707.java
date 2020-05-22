AlchemyLanguage service = new AlchemyLanguage();
service.setApiKey("API_KEY")
Map<String, Object> params = new HashMap<String, Object>();

params.put(AlchemyLanguage.EXTRACT, "authors,concepts,dates,doc-emotion,entities,feeds,keywords,pub-date,relations,typed-rels,doc-sentiment,taxonomy,title");

CombinedResults results=service.getCombinedResults(params).execute();
System.out.println(results);