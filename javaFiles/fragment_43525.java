String[] sent3 = { "It", "can", "can", "it", "." };
// Parser gets second "can" wrong without help (parsing it as modal MD)
String[] tag3 = { "PRP", "MD", "VB", "PRP", "." };                                                 
List<TaggedWord> sentence3 = new ArrayList<TaggedWord>();
for (int i = 0; i < sent3.length; i++) {
  sentence3.add(new TaggedWord(sent3[i], tag3[i]));
}
Tree parse = lp.parse(sentence3);
parse.pennPrint();