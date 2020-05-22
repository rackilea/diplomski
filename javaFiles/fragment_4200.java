public String toString()
{
    Calculations();
    return "Purchase: " + purchase
    + "\nDate: " + date
    +"\nQuantity: " + quantity
    +"\nCost:" + fmt.format(totalCost);
}