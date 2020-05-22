public class ChessboardDOMPrinter {
 private DocumentBuilder builder;

 public void print(String fileName, PrintStream out)
   throws SAXException, IOException {
  Document document = builder.parse(fileName);
  NodeList nodes_i 
    = document.getDocumentElement().getChildNodes();
  for (int i = 0; i < nodes_i.getLength(); i++) {
   Node node_i = nodes_i.item(i);
   if (node_i.getNodeType() == Node.ELEMENT_NODE
       && ((Element) node_i).getTagName()
          .equals("CHESSBOARD")) {
    Element chessboard = (Element) node_i;
    NodeList nodes_j = chessboard.getChildNodes();
    for (int j = 0; j < nodes_j.getLength(); j++) {
     Node node_j = nodes_j.item(j);
     if (node_j.getNodeType() == Node.ELEMENT_NODE) {
      Element pieces = (Element) node_j;
      NodeList nodes_k = pieces.getChildNodes();
      for (int k = 0; k < nodes_k.getLength(); k++) {
       Node node_k = nodes_k.item(k);
       if (node_k.getNodeType() == Node.ELEMENT_NODE) {
        Element piece = (Element) node_k;
        Element position 
          = (Element) piece.getChildNodes().item(0);
        out.println((pieces.getTagName()
                       .equals("WHITEPIECES")
                     ? "White " : "Black ")
                    + piece.getTagName().toLowerCase()
                    + ": "
                    + position.getAttribute("COLUMN")
                    + position.getAttribute("ROW"));
       }
      }
     }
    }
   }
  }
  return;
 }
}