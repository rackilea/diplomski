String val = element.getChildNodes().item(0).getNodeValue();
if (val != null) {
   if (val.startsWith("\n")) { // Discarding pseudo nodes
   } else {
       value = nodnam + " > " + val + " > "
            + getXPath(element); // print node names and
                                // values
       System.out.println(value);
       alist.add(value);
  }
}