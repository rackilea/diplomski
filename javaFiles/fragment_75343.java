public double getRentalFeeDaily() {
        double rentalFeeDaily = 0;
        switch (rentalCarSize) {
        case "Economy":
            rentalFeeDaily = ECONOMY_FEE;
            break;
        case "Midsize":
            rentalFeeDaily = MIDSIZE_FEE;
            break;
        case "Fullsize":
            rentalFeeDaily = FULLSIZE_FEE;
            break;
        case "Luxury":
            rentalFeeDaily = LUXURY_FEE;

        }
        return rentalFeeDaily;
    }