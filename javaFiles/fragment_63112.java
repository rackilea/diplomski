...
WikipediaTokenizer tf = new WikipediaTokenizer(new StringReader(test));
int count = 0;
int numItalics = 0;
int numBoldItalics = 0;
int numCategory = 0;
int numCitation = 0;
TermAttribute termAtt = tf.addAttribute(TermAttribute.class);
TypeAttribute typeAtt = tf.addAttribute(TypeAttribute.class);

while (tf.incrementToken()) {
  String tokText = termAtt.term();
  //System.out.println("Text: " + tokText + " Type: " + token.type());
  String expectedType = (String) tcm.get(tokText);
  assertTrue("expectedType is null and it shouldn't be for: " + tf.toString(), expectedType != null);
  assertTrue(typeAtt.type() + " is not equal to " + expectedType + " for " + tf.toString(), typeAtt.type().equals(expectedType) == true);
  count++;
  if (typeAtt.type().equals(WikipediaTokenizer.ITALICS)  == true){
    numItalics++;
  } else if (typeAtt.type().equals(WikipediaTokenizer.BOLD_ITALICS)  == true){
    numBoldItalics++;
  } else if (typeAtt.type().equals(WikipediaTokenizer.CATEGORY)  == true){
    numCategory++;
  }
  else if (typeAtt.type().equals(WikipediaTokenizer.CITATION)  == true){
    numCitation++;
  }
}
...