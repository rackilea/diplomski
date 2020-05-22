Iterator<CookieOrder> iterator = order.iterator();
while (iterator.hasNext()) {
    // Get the boxes cookie order.
    CookieOrder boxes = iterator.next();

    // Perform the same check as before.
    String type = boxes.getVariety();
    int totalBoxesCookieOrder = boxes.getNumBoxes();
    if(type.equals(cookieType))
    {
        totalRemoved += totalBoxesCookieOrder;

        // Here's where we want to remove it.
        //
        // Instead of calling order.remove, we can use the 
        // "remove" method of the iterator. This is safe.
        iterator.remove();
    }
}