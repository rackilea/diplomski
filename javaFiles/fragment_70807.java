public class BaseRequest {
    private List<Emp> names = new ArrayList<Emp>();

    public setNames(List<Emp> names){
        this.names = names;
    }

    public List<Emp> getNames(){
        return names;
    }
}

public class FirstRequest extends BaseRequest {
    // the rest of your stuff
}