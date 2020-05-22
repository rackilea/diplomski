for (SyndEntry entry : feed.getEntries()) {
    for (Element element : entry.getForeignMarkup()) {
        if (element.getQualifiedName().equalsIgnoreCase("g:id")) {
                product.setId(element.getValue());
        }
    }
}