private Document getDocument(String paragraph)
       {
           Document document = new Document();
           Field paragraphContents = new Field(LuceneConstants.paragraph,
           paragraph, Field.Store.YES, Field.Index.ANALYZED);
           document.add(paragraphContents);        
        return document;           
       }