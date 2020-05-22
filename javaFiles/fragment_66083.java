public class DaDataBody{

    @SerializedName("from_bound")
    private Property fromBound;

    @SerializedName("query")
    private String query;

    @SerializedName("count")
    private int count;

    @SerializedName("to_bound")
    private Property toBound;

    public void setFromBound(Property fromBound){
        this.fromBound = fromBound;
    }

    public Property getFromBound(){
        return fromBound;
    }

    public void setQuery(String query){
        this.query = query;
    }

    public String getQuery(){
        return query;
    }

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setToBound(Property toBound){
        this.toBound = toBound;
    }

    public Property getToBound(){
        return toBound;
    }

    public class Property {

        @SerializedName("value")
        private String value;

        public void setValue(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }


    }
}