@TokenFilterDef(
    factory = SynonymFilterFactory.class,
    params = {
        @Parameter(name = "ignoreCase", value = "true"),
        @Parameter(name = "expand", value = "true"),
        @Parameter(name = "synonyms", value = "synonymsfile"),
        @Parameter(name = "format", value = "wordnet") // Add this
    }
)