public class Metadata{
    public String uri;
    public String Query;
    public String ID;
    public String Title;
    public String Description;
    public String DisplayUrl;
    public String Url;
}

public class ResponseResults{
    public MetadataContainer[] results;
    public String __next; 
}


public class MetadataContainer{
    public Metadata __metadata;
}


public class ResponseData{
    public ResponseResults d;
}

String json; //Your json response
ResponseData myD = new Gson().fromJson(json, ResponseData.class);