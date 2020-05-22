public class DataContainer {
    public Data d;
}

public class Data {
    public Result[] results;
    public String __next;
}

public class Result {
    public Metadata __metadata;
    public String ID;
    public String Title;
    public String Description;
    public String DisplayUrl;
    public String Url;
}

public class Metadata {
    public String uri;
    public String type;
}