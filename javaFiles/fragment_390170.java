public CarRental(String name, String zipCode, String size,  int rentalDays)
{
    this.name = name;
    this.zipCode = zipCode;
    this.size = size;
    if (size.equals("e"))
    {
        dailyFee = 29.99;
    }
    else if (size.equals("m"))
    {
        dailyFee = 38.99;
    }
    else if (size.equals("f"))
    {
        dailyFee = 43.50;
    }
    this.rentalDays = rentalDays;
    this.totalFee = dailyFee * rentalDays;;
}