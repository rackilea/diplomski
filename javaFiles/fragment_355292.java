public class Subgroup {

    private String fname;
    private String mname;
    private String lname;

    //getter-setter

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Subgroup sg = new Subgroup();
        sg.setFname(this.fname);
        sg.setMname(this.mname);
        sg.setLname(this.lname);
        return sg;
    }

     //to-string

}