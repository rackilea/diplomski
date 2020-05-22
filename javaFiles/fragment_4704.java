class Entry {
    private String value;
    private String description;

    ...
}

class Config { 
    private Properties properties;

    public Entry get(String key) {
        // get the value for key
        // get the value for key.description
        // create and return an Entry
    }
}