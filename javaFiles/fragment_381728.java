public static void main(String[] args) {
    String   input    = "id: 123487, street1: Stanton, street2: Gateway, street3: Hawkins, city: Horizon";
    Location location = parseLocation(input);

    System.out.println(String.format("id: %d\n"
            + "street1: %s\n"
            + "street2: %s\n"
            + "street3: %s\n"
            + "city: %s", location.getId(), 
            location.getStreet1(), location.getStreet2(), 
            location.getStreet3(), location.getCity()));
}