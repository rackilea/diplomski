final Map<String, Integer> country2count = new HashMap<String, Integer>();
    for (final ScoreDoc hit : hits) {
        final int docId = hit.doc;
        if (!reader.isDeleted(docId)) {
            // Get the document from docId
            final Document document = searcher.doc(docId);
            // Get the country
            final String country = document.get("from");

            if(country2count.containsKey(country)){
                int prevCount = country2count.get(country);
                country2count.put(country, ++prevCount);
            }else{
                country2count.put(country, 1);
            }
        }
    }