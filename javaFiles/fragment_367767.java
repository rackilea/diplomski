public class Test {     
    private static int count = 0;

    public static void main( String [] args) { 
        House h1 = new House("blueberry", "town1", "fred");
        System.out.println(h1.toString());
        House h2 = new House("blackberry", "town2", "barney");
        System.out.println(h2.toString());
        House h3 =new House("redberry", "town3", "john");;
        System.out.println(h3.toString());              
    } 
}

class House {
    String name;
    String person;
    String town;
    private int propertyCode;
    static int count = 0;

    public House(String name,String town,String person){
        count = count +1;
        this.propertyCode = count;
        this.town = town;
        this.person = person;
        this.name = name;

    }
    public String toString(){
        String temp = "";
        temp = "Code: " + this.name + " " + this.propertyCode;
        return temp;
    }

}