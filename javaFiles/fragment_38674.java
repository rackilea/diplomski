public List<String> populateWithAvailableLanguages(List<String> list) {
    Iterator<Map.Entry<String, String>> it = this.iterator();
    // List<String> list = new ArrayList<String>();
    while (it.hasNext()) {
        Map.Entry<String, String> n = it.next();
        list.add(n.getKey());
    }
}