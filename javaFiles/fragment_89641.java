private void performDNSLookup(String address) {
    try {
        Resolver resolver = new SimpleResolver();
        Lookup lookup = new Lookup(address, Type.TXT);
        lookup.setResolver(resolver);
        Record[] record = lookup.run();
        for (int i = 0, len = record.length; i < len; i++)
            System.out.println(record[i].rdataToString() + "\n"
                    + record.length);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}