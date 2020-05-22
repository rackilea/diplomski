class Node {
  @XmlJavaTypeAdapter(value=NodeValueStringAttrMarshaller.class)
  String subnode;

  @XmlJavaTypeAdapter(value=NodeValueLongAttrMarshaller.class)
  Long anotherSubNode;
  //...
}