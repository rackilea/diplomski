for (XdmItem item : result) {
   XdmNode ns = (XdmNode)item;
   String prefix = ns.getNodeName()==null ? "" : ns.getNodeName().getLocalName();
   String uri = ns.getStringValue();
   ...
}