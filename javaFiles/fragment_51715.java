public class engineSpecs{
    public String name;
    public engineSpecs(String s){
        this.name = s;
    }

    public boolean is(String car){
        return this.name.equals(car);
    }

    public String toString(){
        return this.name;
    }
}