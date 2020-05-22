String[] mailAddressTo = { "Chuck.Norris@yahoo.com", "Bill.Clinton@gmail.com" };

StringBuilder addressList = new StringBuilder();
String separator = "";
for (String address : mailAddressTo) {
    addressList.append(separator).append(address);
    separator = ",";
}

Desktop.getDesktop().mail(new URI("mailto", addressList.toString(), null));