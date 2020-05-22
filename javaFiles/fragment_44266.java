groupById.entrySet().stream().map(x -> {
    // assuming your constructor's parameters go in the order of name, qty, price, platIds
    return new Truck(x.getValue().get(0).getNamePart(), 
              x.getValue().get(0).getQtyPart(), 
              x.getValue().get(0).getPricePart(),
              x.getValue().stream().map(TruckPart::getPartId).collect(Collectors.toList()));
})