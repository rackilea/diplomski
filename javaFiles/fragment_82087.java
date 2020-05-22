class Person {
    private String name;
    private String location;

    public Person(String name,String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

public class Test {
    public static void main(String[] args) {

        List<Person> productList = new ArrayList<>();
        productList.add(new Person("Amit","india"));
        productList.add(new Person("A", "bangalore"));

        // case 1 :- when you know the location of person in LL.
        System.out.println(productList.get(0).getName());

        // case 2:- when you know some unique peroperty of person and filtering on base of this.
        for(Person product : productList){
            if(product.getLocation().equalsIgnoreCase("india")){
                System.out.println("name of person " + product.getName());
            }
        }
    }
}

Output :-
Amit
name of person Amit