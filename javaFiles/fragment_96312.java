class CarRental {
    public          String      rentalCarSize    = "";
    public          double      rentalFeeDaily;
    public          int         rentalLength     = 0;
    public          double      rentalFeeTotal   = 0d;

    public CarRental(int days, String carSize)
    {
        rentalCarSize   = carSize;
        rentalLength    = days;
        rentalFeeTotal   = getRentalFeeDaily(carsize)*rentalLength;

    }