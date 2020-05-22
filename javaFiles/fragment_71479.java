public @interface Entity {
    String name();
}


public class Car implements Entity{
    public String name(){ return "car"; }
}