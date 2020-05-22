@Value("#{externalConfigProperties['myProperty'].split(',')}")
public void setMyProperty(List<String> myProperty) {
    this.myProperty = new ArrayList<Integer>();
    for (String t:myProperty) {
        try {
            this.myProperty.add(Integer.valueOf(t));
        }catch (NumberFormatException e) {

        }
    }
}