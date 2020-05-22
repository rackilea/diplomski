public  class UrlMap {
    private Map<URL, Long> map;

    public UrlMap() {
        map = new HashMap<URL, Long>();
    }

    public void setTimestamp(URL url, long timestamp) {
        map.put(url, timestamp);
    }

    public long getTimestamp(URL url) {
        return map.getOrDefault(url, -1L);
    }

}