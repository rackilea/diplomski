public void writeOrder(PrintWriter pw) {
    pw.println("Order Summary:");
    for (Order order : orders) {
        // NOTE: If possible, I would move this code into Order.toString()
        //       and then use pw.println(order);
        pw.print("    Product Id: ");
        pw.print(order.getProductCode());
        pw.print("    Product Description: ");
        pw.print(order.getProductDesc());
        pw.print("    Order Quantity: ");
        pw.print(order.getQuantity());
        pw.print("    Order Cost: £");
        pw.println(order.getCost());
    }
    pw.print("Total Cost: ");
    pw.print(getTotalCost());
    pw.print("p        Number of Orders: ");
    pw.print(numOfOrders());
    pw.print("     Total Products: ");
    pw.println(numOfProducts());
}