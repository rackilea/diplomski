@Override
public String toString() {

   DecimalFormat format = new DecimalFormat("#.00");

   return "From: " + sender + ... + format.format(baseCost());
}