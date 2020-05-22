public class Application {

    public static void main(String[] args) {

        // define some unique shipments
        Shipment a = new Shipment(1,1, 10.0, 20.3, "Denver", "Seattle", "xyz");
        Shipment b = new Shipment(2,9, 45.88, 130.1, "Denver", "Los Angeles", "xyz");
        Shipment c = new Shipment(3,3, 14.67, 6.8, "Houston", "Dallas", "xyz");
        Shipment d = new Shipment(1,4, 12.99, 2.3, "New York", "London", "xyz");

        // populate your inventory with an array of initial shipments "a", "b", and "c"
        Shipment[] initialShipments = new Shipment[] { a, b, c };
        Inventory inventory = new Inventory(initialShipments);

        // print the inventory before adding the new shipment
        System.out.println(inventory.toString());

        // add shipment "d" to your inventory with the new method
        try {
            inventory.addShipment(d);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // print the inventory after adding the new shipment
        System.out.println(inventory.toString());
    }

}