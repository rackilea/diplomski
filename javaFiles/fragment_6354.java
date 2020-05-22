XMLLexicon lexicon = new XMLLexicon("path\\to\\default-lexicon.xml");
WordElement word = lexicon.getWord("live", LexicalCategory.VERB);
InflectedWordElement infl = new InflectedWordElement(word);
infl.setFeature(Feature.TENSE, Tense.PAST);
Realiser realiser = new Realiser(lexicon);
String past = realiser.realise(infl).getRealisation();
System.out.println(past);