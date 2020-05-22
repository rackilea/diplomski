public class Group {

    private Subgroup sg;

    //getter-setter

    public Object clone() throws CloneNotSupportedException {
        Group g = new Group();
        g.setSg((Subgroup) this.sg.clone());
        return g;
    }
    //to-string

}