public class LocationLogic implements Logic{
    private final boolean accessible;

    public LocationLogic(boolean accessible){
        this.accessible = accessible;
    }

    public boolean logicAccessible(){
        return accessible;
    }
}