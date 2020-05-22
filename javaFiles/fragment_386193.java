public class FBUserVideoWatches {

    private List<Data> data;

    public List<Data> getData() { return data; }

    public void setData(List<Data> data) {  this.data = data;}
}


public class Data {

    private TVData data;

    private String id;
    private String type;

// setter/getter here
}

public class TVData {

    @SerializedName(value="tv_show")
    private Show show;
// setter/getter here
}

public class Show {

    private String id;
    private String url;
    private String type;
    private String title;
       // setter/getter here
   }