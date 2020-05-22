public Contact (String theName, PhoneNumber p)
{
    // You must allocate a PhoneNumberList here
    numbers = new PhoneNumberList();
    name = theName;
    numbers.add(p);

}