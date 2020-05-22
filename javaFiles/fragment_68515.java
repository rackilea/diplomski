Map<Integer, Double> scoreMap = new HashMap<>();
XPath xpath = XPathFactory.newInstance().newXPath();
NodeList questions = (NodeList) xpath.evaluate("/root/Q", document, XPathConstants.NODESET);
for (int i = 0; i < questions.getLength(); i++) {
  Node question = questions.item(i);
  int questionId = Integer.parseInt(xpath.evaluate("QID", question));
  System.out.println("question: " + questionId);
  NodeList answers = (NodeList) xpath.evaluate("Ans/Score", question, XPathConstants.NODESET);
  double maxScore = 0;
  for (int j = 0; j < answers.getLength(); j++) {
    System.out.println("score: " + answers.item(j).getTextContent());
    double score = Double.parseDouble(answers.item(i).getTextContent());
    maxScore = Math.max(score, maxScore);
  }
  scoreMap.put(questionId, maxScore);
}
scoreMap.forEach((k, v) -> System.out.println(k + ": " + v));