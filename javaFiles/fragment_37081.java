dataspec[DataLayout layout] returns [DataExtractor extractor]
    @init {
        DataExtractorBuilder builder = new DataExtractorBuilder($layout);
    }
    @after {
        $extractor = builder.create();
    }
    : first=expr { builder.addAll($first.ext); }
        (COMMA next=expr { builder.addAll($next.ext); })* 
    ;