String firstRandomElementSelector = "div:containsOwn(test):first-of-type";
String secondRandomElementSelector = "div:containsOwn(test):last-of-type";

Document doc = ...;
Element firstRandomElement = select(doc, firstRandomElementSelector);
Element secondRandomElement = select(doc, secondRandomElementSelector);

List<Node> siblingNodes = firstRandomElement.siblingNodes();
List<Node> nodesInBetween = new ArrayList<>();

Node currentNode = firstRandomElement;
do {
   Node nextSibling = currentNode.nextSibling();
   if (nextSibling == null) {
      break;
   }

   if (secondRandomElement.equals(nextSibling)) {
      break;
   }

   nodesInBetween.add(nextSibling);
   currentNode = nextSibling;
} while(true);

for(Node node : nodesInBetween) {
   System.out.println(node.outerHtml() + "---");
}

// Helper method
private static Element select(Document doc, String cssSelector) {
   Element element = doc.select(cssSelector).first();
   if (element == null) {
       throw new RuntimeException("Unable to locate any element matching:" + cssSelector);
   }
}