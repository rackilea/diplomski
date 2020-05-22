for (Element x : doc.getElementsByTag("a")) {
    URI uri = URI.create(x.absUrl("href"));
    boolean isOffline = uri.getScheme().equalsIgnoreCase("file");

    if (isOffline) {
        System.out.println("Offline Link -> " + x.attr("href"));
        // ...
    }
}