class MyMimeTypes {
    @JsonIgnore
    private String[] mimeTypesArray;

    /** A convenience method for setting just one item. */
    public void setMimeType(String mimeType) {
        this.mimeTypesArray = new String[] { mimeType };
    }

    public void setMimeTypes(String[] mimeTypes) {
        this.mimeTypesArray = mimeTypes;
    }

    // The JSON-specific part:

    @JsonProperty("mimeTypes")
    public Object jsonMimeTypes() {
        if (mimeTypesArray.length == 1)
            return mimeTypesArray[0];
        else
            return mimeTypesArray;
    }
}