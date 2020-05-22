public static void main(String[] args) throws Exception {
    SelectiveIndexedDocumentFactory factory = new SelectiveIndexedDocumentFactory(QName.get("innerEle"));
    SAXReader reader = new SAXReader();
    reader.setDocumentFactory(factory);
    Document doc = reader.read(...);

    factory.getElements(QName.get("innerEle")).stream()
        .forEach(e -> System.out.println(e.getName()));

}


static class SelectiveIndexedDocumentFactory extends DocumentFactory {
    private Set<QName> indexedElements = new HashSet<>();

    private Map<QName, List<Element>> index = new HashMap<>();

    public SelectiveIndexedDocumentFactory(QName...indexedElements) {
        this.indexedElements.addAll(Arrays.asList(indexedElements));
    }

    public List<Element> getElements(QName qn) {
        return index.containsKey(qn) ? index.get(qn) : Collections.emptyList();
    }


    @Override
    public Element createElement(QName qname) {
        Element e = super.createElement(qname);
        if (indexedElements.contains(qname)) {
            List<Element> l = index.get(qname);
            if (l == null) {
                l = new ArrayList<>();
                index.put(qname, l);
            }
            l.add(e);
        }
        return e;
    }

}