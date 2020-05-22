@Cacheable
public List<String> getData(String clientName) {
    List<String> data = Collections.synchronizedList(new ArrayList<String>());
    // load data for the client from external process and add it to the list...
    return data;
}