long unsignedAdjustment = 4294967296L;  // 2^32
long l = 3791318595L;  // our test value
if (l > unsignedAdjustment) {
    System.out.println("Error: ID value too large to fit, even if wrapped to non-positive integer.");
}
else {
    int signedID = 0;
    if (l > 2147483647L) {  // (2^31)-1
        signedID = (int) (l - unsignedAdjustment);
    }
    else {
        signedID = (int) l;
    }
    myTable.addRow(signedID, "testing");
}