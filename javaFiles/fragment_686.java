XPathFactory xpf = XPathFactory.instance();
XPath<Element> xp = xpf.compile("//myobject[@name='propert6']", Filters.element());
Element propert6 = xp.evaluateFirst(Dataelement);

Element toinsert = new Element("toinsert");
Element parent = toinsert.getParent();
parent.addContent(parent.indexOf(propert6), toinsert);