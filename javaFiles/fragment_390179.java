public abstract class Animal {

    private String fname;

    private String lname;

    private int size;

    public Animal(String fname, String lname, int size) {
       this.fname = fname;
       this.lname = lname;
       this.size = size;
    }

   //getters and setters
    public String getFName(){
        return fname;
    }
    public void setFName(String fname){
        this.fname = fname;
    }

    public String getLName(){
        return lname;
    }
    public void setLName(String lname){
        this.lname = lname;
    }

    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }

    //compare by fname
    public int compareTo(Animal lname) {
        return fname.compareTo(lname.fname);
    }

    //sound method
    abstract String sound();



    //toString method
    @Override
    public String toString(){
        return getFName() + " " + getLName() + " " + sound() + " " + getSize();
    }



}