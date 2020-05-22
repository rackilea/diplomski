public class ForecastWeather {

private String cod;
private String message;
private Integer cnt;
private City city;
private java.util.List<SomeObject> list = new ArrayList<SomeObject>();

public List<String> getAsStringList(){
    List<String> l=new ArrayList<>();
    for(SomeObject someObject:list){
        //You can override the toString() function of SomeObject class
        l.add(someObject.toString());
    }
    return l;
}
}