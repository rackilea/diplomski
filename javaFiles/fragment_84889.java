public class House {
    public String address;
    public String type;

    public House(String add){
        this.address = add;
    }  

    @Override
    public String toString() {
        return (address + "-" + type) ;
    }
}