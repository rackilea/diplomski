public static Adres read(Scanner sc) {
    String street = sc.next();
    String number = sc.next();
    String code = sc.next();
    String place = sc.next();
    return new Adres(street, number, code, place);
}