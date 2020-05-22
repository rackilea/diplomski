byte[] productionDate = new byte[]{
        (byte) (unixTime >> 24),
        (byte) (unixTime >> 16),
        (byte) (unixTime >> 8),
        (byte) unixTime

};