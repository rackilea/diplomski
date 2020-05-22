if(error.Colour() == /*insert value to check here*/)
{
    calculate.setKey(key);
    calculate.setQuantity(QuantityInt);
    double cost = calculate.calculateBill();
    information.append("\n\nTotal cost: £" + pounds.format(cost));
}