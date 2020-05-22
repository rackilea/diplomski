class Book{

    HashMap<String, String> features;

    public Book(){
        this.features= new HashMap<String,String>();
    }

    public HashMap<String, String> getFeatures() {
        return features;
    }

    public String addFeature(String key,String value){
        return features.put(key, value);
    }

    public void addFeatures(HashMap<String, String> newFeatures){
        this.features.putAll(newFeatures);
    }
}