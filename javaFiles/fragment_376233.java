@Override
public String toString() {
    DecimalFormat format = new DecimalFormat("#.00");
    return String.format("%d * GBP %5s %15s= GBP %5s", quantity, format.format(price), 
                                                name, format.format(price * quantity));

}