int numberOfBits;
    for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {

        if ((netmaskNumeric << numberOfBits) == 0)
            break;
    }
    Integer numberOfIPs = 0;
    for (int n = 0; n < (32 - numberOfBits); n++) {

        numberOfIPs = numberOfIPs << 1;
        numberOfIPs = numberOfIPs | 0x01;

    }

    Integer baseIP = baseIPnumeric & netmaskNumeric;
    String firstIP = convertNumericIpToSymbolic(baseIP + 1);
    String lastIP = convertNumericIpToSymbolic(baseIP + numberOfIPs - 1);
    return firstIP + " - " + lastIP;
}