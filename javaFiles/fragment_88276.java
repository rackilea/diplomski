while ((thisLine = reader.readLine()) != null) { // only read once per loop.
    String propertyDetails[] = thisLine.split(",");
    if (propertyDetails[0].equals(userName)) {
        System.out.print("\nUser: " + propertyDetails[0] + "\nAddress: " + propertyDetails[1] + "\nEst. Value: " + propertyDetails[2]
                + "\nLocation Cat: " + propertyDetails[3] + "\nPrivate Residence: " + propertyDetails[4] + "\nTax Paid: " + propertyDetails[5] + "\nTax Due: " + propertyDetails[6] + breakLine);

    }
}
// out side the loop.
System.out.print("\nNo Further Properties Found For This User\n");