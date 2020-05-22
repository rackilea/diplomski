public class Dog extends Pet{
    protected String smell;
    private String species;

    public Dog(String smell){
        super(15, "Dog", "Rex");
        this.smell = smell;
    }

    public Dog(){

    }

    public void setSmell(String smell){
        this.smell = smell;
    }

    public String getSpecies(){
       super.getSpecies();
    }

    public String getSmell(){
        return this.smell;
    }

}