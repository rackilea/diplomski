public static void printNode(Document d) {
    try {
      NodeList values = (NodeList) XPathFactory.newInstance()
          .newXPath()
          .evaluate("//param-value/text()", d, XPathConstants.NODESET);

      for (int i = 0; i < values.getLength(); i++) {
        System.out.println(values.item(i).getTextContent());
      }
    } catch (XPathExpressionException e) {
      throw new IllegalStateException(e);
    }
  }