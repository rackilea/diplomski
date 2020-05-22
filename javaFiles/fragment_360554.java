package remoting;
public class Product {

    private String name;
    private int id;
    private Boolean isVisible;

    public Product() {
            name = "Product 0.1";
            id = 123;
            isVisible = false;
    }
    public void setName(String _name){
            name = _name;
    }
    public String getName(){
            return name;
    }
    public void setId(int _id){
            id = _id;
    }
    public int getId(){
            return id;
    }
    public void setIsVisible(Boolean _isVisible){
            isVisible = _isVisible;
    }
    public Boolean getIsVisible() {
            return isVisible;
    }
}