public class UseCarRental {
    public static void main(String[] args) {
        CarRental cr = new CarRental("Honda", 1234, 10, "Economy");
        LuxuryCarRental lcr = new LuxuryCarRental("Jaguar", 5678, 10);

        System.out.println(cr.totalRentalFee());
        System.out.println(lcr.totalRentalFee());

    }
}