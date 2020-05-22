class Results {

    private String id;
    private String language;
    private List<LexicalEntry> lexicalEntries;
    private String type;
    private String word;

//
}

public class LexicalEntry {

    private List<Derivative> derivatives;
    private List<Entry> entries;
    private String language;
    private String lexicalCategory;
    private List<Pronunciation> pronunciations;
    private String text;
//
}

class Derivative {

    private String id;
    private String text;
//
}


class Entry {

    private List<String> etymologies;
    private List<GrammaticalFeature> grammaticalFeatures;
    private String homographNumber; //if it has quotes in JSON, it will be a string not int..JSON is a strongly typed object notation
    private List<Sense> senses;
    //
}

class GrammaticalFeature{
    String text;
    String type;
}



public class Pronunciation {
    private String audioFile;
    private List<String> dialects;
    private String phoneticNotation;
    private String phoneticSpelling;
//
}

class Sense {

    private List<String> definitions;
    private List<Example> examples;
    private String id;
    private List<String> short_definitions;
    private List<Subsense> subsenses;
    private List<ThesaurusLinks> thesaurusLinks;
//

}

class Example{
    String text;
}

class Subsense {

    private List<String> definitions;
    private List<String> domains;
    private List<Example> examples;
    private String id;
    private List<String> shortDefinitions;
    private List<ThesaurusLink> thesaurusLinks;
//
}

class ThesaurusLink {
    private String entry_id;
    private String sense_id;
//
}