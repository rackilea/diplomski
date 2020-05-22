for (int idx = 0; idx < zoneBundle.getSize(); idx++) {
    UResourceBundle mz = zoneBundle.get(idx);
    String mzid = mz.getString(0);
    String fromStr = "1970-01-01 00:00";
    String toStr = "9999-12-31 23:59";
    if (mz.getSize() == 3) {
        fromStr = mz.getString(1);
        toStr = mz.getString(2);
    }
    long from, to;
    from = parseDate(fromStr);
    to = parseDate(toStr);
    mzMaps.add(new MZMapEntry(mzid, from, to));
}