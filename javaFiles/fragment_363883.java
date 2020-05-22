class Shirt{

    enum ShirtSize{SMALL,MEDIUM,LARGE,XL}
    ShirtSize size;
}

public class Enumeration {

    public static void main(String[] args) {
        Shirt clothes=new Shirt(); // fixed here!
        clothes.size=Shirt.ShirtSize.LARGE;
        System.out.println("Size: "+clothes.size);
    }
}