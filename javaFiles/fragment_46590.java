import java.util.List;


public class Levels {
    private Number id;
    private String name;
    private List sequence;

    public Number getId(){
        return this.id;
    }
    public void setId(Number id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List getSequence() {
        return sequence;
    }
    public void setSequence(List sequence) {
        this.sequence = sequence;
    }
}