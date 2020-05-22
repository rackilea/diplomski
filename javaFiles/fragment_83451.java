@Override
    public Boolean addWords(Set<String> words) throws IOException{

        synchronized(modifyCurrentIndexLock){

        IndexWriterConfig wConfig = new IndexWriterConfig(new SimpleAnalyzer());
        wConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);

        try(Directory spellIndex = FSDirectory.open(new File(indexLocation).toPath());
            SpellChecker spellchecker = new SpellChecker(spellIndex); 
            IndexWriter writer = new IndexWriter(spellIndex, wConfig);)
        {
            for(String word:words){
                if(!spellchecker.exist(word)){

                    logger.debug("Word -> "+word +" doesn't exist in dictionary to trying to add to index");
                    Document doc = createDocument(word, getMin(word.length()), getMax(word.length()));
                    writer.addDocument(doc);
                    writer.commit();
                }
            }
            logger.debug("All valid words added to dictionary");
            return true;
        }

        }

    }