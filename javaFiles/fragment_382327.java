NodeList resources = fstElmnt.getElementsByTagName("resources");
  for (int k = 0; k < resources.getLength(); k++) {
      Node resNode = resources.item(k);
      if (resNode.getNodeType() == Node.ELEMENT_NODE) {
          Element resElement = (Element)resNode;
          if (resElement.hasAttribute("lang") &&
                   resElement.getAttribute("lang").equals("en")) {
              //your existing code here for value, label, hint
          }
      }
   }