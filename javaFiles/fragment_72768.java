public class MyImage extends Image{

    private String id;

    public MyImage(String url){
        super(url);
    }

    public MyImage(String url, String id){
        super(url);
        this.id = id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

}