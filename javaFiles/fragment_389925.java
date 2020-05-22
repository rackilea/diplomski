private static void OutputJaxpImplementationInfo() {
    System.out.println(getJaxpImplementationInfo("DocumentBuilderFactory", DocumentBuilderFactory.newInstance().getClass()));
    System.out.println(getJaxpImplementationInfo("XPathFactory", XPathFactory.newInstance().getClass()));
    System.out.println(getJaxpImplementationInfo("TransformerFactory", TransformerFactory.newInstance().getClass()));
    System.out.println(getJaxpImplementationInfo("SAXParserFactory", SAXParserFactory.newInstance().getClass()));
}

private static String getJaxpImplementationInfo(String componentName, Class componentClass) {
    CodeSource source = componentClass.getProtectionDomain().getCodeSource();
    return MessageFormat.format(
            "{0} implementation: {1} loaded from: {2}",
            componentName,
            componentClass.getName(),
            source == null ? "Java Runtime" : source.getLocation());
}