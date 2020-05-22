double totalBytes = (double) TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
double mobileBytes = TrafficStats.getMobileRxBytes() + TrafficStats.getMobileTxBytes();
totalBytes -= mobileBytes;
totalBytes /= 1000000;
mobileBytes /= 1000000;

NumberFormat nf = new DecimalFormat("#.##");
String totalStr = nf.format(totalBytes);
String mobileStr = nf.format(mobileBytes);
String info = String.format("\tWifi Data Usage: %s MB\tMobile Data Usage, %s", totalStr, mobileStr);