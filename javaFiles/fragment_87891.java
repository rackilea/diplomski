public class XPathUtils implements IXPath {

    private Document doc;
    private XPath xpath;
    private SimpleNamespaceContext nsCtx;

    public XPathUtils(String baseString) throws HanaHttpConnectivityException {
      // as before
      // .......
      xpath = XPathFactory.newInstance().newXPath();
      nsCtx = new SimpleNamespaceContext();
      xpath.setNamespaceContext(nsCtx);
    }

    public Object getObjectValue(String strValue, String... namespaces) throws HanaHttpConnectivityException {
        try {
            if(namespaces != null) {
              // namespaces array is [prefix1, uri1, prefix2, uri2, ...]
              for(int i = 0; i < namespaces.length; i++) {
                nsCtx.bindNamespaceUri(namespaces[i], namespaces[++i]);
              }
            }
            XPathExpression xpathExp = xpath.compile(strValue);
            return xpathExp.evaluate(doc,XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new HanaHttpConnectivityException(e);
        } finally {
            nsCtx.clear();
        }

    }
}