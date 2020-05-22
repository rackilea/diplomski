Collections.sort(documentLinks,
    new Comparator<LinkModelSpi>() {
      @Override
      public int compare(LinkModelSpi o1, LinkModelSpi o2) {
        return o1.getResource().compareTo(o2.getResource());
      }
});