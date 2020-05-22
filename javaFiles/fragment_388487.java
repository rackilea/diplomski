public String[] getStrings()
    Object[] oValues= toArray();
    String[] sValues = new String[oValues.length];
    for (int index = 0; index < oValues.length; index++) {
        sValues[index] = oValues[index].toString();
    }
    return sValues;
}