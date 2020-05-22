public static void main (String ... args) {
    ArrayList<Contanct> contacts = new ArrayList<Contact>();

    Contact c1= new Contact();
    c1.setName("John");
    c1.setAddress("Arthur Street 10");
    c1.setTelephone("123");

    Contact c2= new Contact();
    c2.setName("Peter");
    c2.setAddress("Sam Street 2");
    c2.setTelephone("456");

    contacts.add(c1);
    contacts.add(c2);

    String result= "";
    //Put it to a String
    for (Contact c : contacts) {
        result+=c.toString() + "$";
    }
    result = result.substring(0, result.length() - 1);

    System.out.println(result);
}