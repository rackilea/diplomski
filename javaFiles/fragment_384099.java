public class Person{
    int id;
    String name;
    //fields, getter, setter, constructor omited....

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Person)){
            //implicit null check
            return false;
        }
        return this.id==((Person)o).id;
    }

    @Override
    public int hashCode(){
        return this.id;
    } 
}