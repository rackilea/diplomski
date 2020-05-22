org.jdom2.Document doc = new SAXBuilder().build(new StringReader(queryDef.serialize()));
if (!StringUtils.isEmpty(orderBy)) {
    Element operatorState = new Element("operator-state", NAMESPACE_SEARCH);
    operatorState.addContent(new Element("operator-name", NAMESPACE_SEARCH).setText("sort"));
    operatorState.addContent(new Element("state-name", NAMESPACE_SEARCH).setText(orderBy));
    doc.getRootElement().addContent(operatorState);
}
RawStructuredQueryDefinition rawQueryDef =
                queryManager.newRawStructuredQueryDefinition(new JDOMHandle(doc), OPTIONS_ALL);
// ~~
SearchHandle resultsHandle = new SearchHandle();
queryManager.search(rawQueryDef, resultsHandle, start);