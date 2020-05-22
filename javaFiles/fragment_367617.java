public class Inventory {

    private ArrayList<Shipment> shipments;

    public Inventory(Shipment[] shipments) {
        if(shipments == null) {
            throw new IllegalArgumentException("List of shipments cannot be null.");
        }
        this.shipments = new ArrayList<>(Arrays.asList(shipments));
    }

    public void addShipment(Shipment shipment) throws Exception {

        Optional<Shipment> duplicateShipment = shipments
                .stream()
                .filter(otherShipment -> otherShipment.getTrackingCode() == shipment.getTrackingCode())
                .findAny();

        if(duplicateShipment.isPresent()) {
            String errorMessage = MessageFormat.format(
                    "A shipment with tracking code {0} already exists in this inventory.",
                    shipment.getTrackingCode()
            );
            throw new Exception(errorMessage);
        }
        else {
            this.shipments.add(shipment);
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "shipments=" + shipments +
                '}';
    }
}