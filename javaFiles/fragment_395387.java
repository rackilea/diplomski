public static FligtPriceDTO calculatePrice(List<Flight> flightList) {
        FligtPriceDTO dto = new FligtPriceDTO();
        int price = 0;
        int pricePerPassenger = 0;
        for (Flight flight : flightList) {
            price = price + flight.getPrice();
            pricePerPassenger = (pricePerPassenger) + (flight.getPrice() / flight.getPassgers());
        }
        dto.setPrice(price);
        dto.setPricePerPassenger(pricePerPassenger);
        return dto;
    }
}

class FligtPriceDTO {
    private int price;
    private int pricePerPassenger;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPricePerPassenger() {
        return pricePerPassenger;
    }

    public void setPricePerPassenger(int pricePerPassenger) {
        this.pricePerPassenger = pricePerPassenger;
    }

}