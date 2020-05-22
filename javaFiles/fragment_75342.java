public void display()
    {
        System.out.println(
                "Customer Details" +
                "\nName          = " + getrenterName() +
                "\nZipcode       = " + rentalZipCode +
                "\nCar Size      = " + getrentalCarSize() +
                "\nRental Fee    = " + getRentalFeeDaily + "/daily" +
                "\nRental Length = " + numDaysRented +
                "\nTotal Fee     + " + totalRentalFee
        );
    }