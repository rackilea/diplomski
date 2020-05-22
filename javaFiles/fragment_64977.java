void readXml(Xml xml) {
  if (xml instanceof XmlSet) readSet(xml);
  else if (xml instanceof XmlList) readList(xml);
  else if (xml instanceof XmlType) readType(xml);
}

void readSet(Xml xml) {
  /*here you loop through the elements of set and call readXml(child)*/
}

void readList(Xml xml) {
  /*here you loop through the elements of list and call readXml(child).*/
}

void readType(Xml xml) {
  /* Here you use reflection to populate the value of elements with the corresponding java types */
}