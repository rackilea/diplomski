Collections.sort(documentLinks,
    new Comparator<LinkModelSpi>() {
      @Override
      public int compare(LinkModelSpi o1, LinkModelSpi o2) {
        String resource1, resource2; // String or whatever type the getResource method returns
        if (o1 instanceof DocumentLinkModelImpl) {
            resource1 = ((DocumentLinkModelImpl)o1).getResource();
        } else if (o1 instanceof LinkModelImpl) {
            resource1 = ((LinkModelImpl)o1).getResource();
        } else {
            throw new IllegalArgumentException();
        }
        if (o2 instanceof DocumentLinkModelImpl) {
            resource2 = ((DocumentLinkModelImpl)o2).getResource();
        } else if (o2 instanceof LinkModelImpl) {
            resource2 = ((LinkModelImpl)o2).getResource();
        } else {
            throw new IllegalArgumentException();
        }
        return resource1.compareTo(resource2);
      }
});