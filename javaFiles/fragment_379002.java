public static class User {
    @Parsed
    String name;
    @Parsed
    String gender;
    @Nested
    Address address;
    @Parsed
    long number;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", number=" + number +
                '}';
    }
}

public static  class Address {
    @Parsed(field = "address_first_line")
    String firstLine;
    @Parsed(field = "address_second_line")
    String secondLine;

    @Override
    public String toString() {
        return "Address{" +
                "firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                '}';
    }
}

public static void main(String ... args){
    StringReader input = new StringReader(
            "name,gender,address_first_line,address_second_line, city,number\n" +
            "John,M,Somewhere,Else,City,1");


    for(User user : new CsvRoutines().iterate(User.class, input)){
        System.out.println(user.toString());
    }

}