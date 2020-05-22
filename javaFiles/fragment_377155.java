public static String uuidToBase64(String str) {
        java.util.Base64.Encoder encoder=Base64.getEncoder();
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        byte[] java=bb.array();
        byte[] net= new byte[16];
        for (int i = 8; i < 16; i++) {
            net[i] = java[i];
        }
        net[3] = java[0];
        net[2] = java[1];
        net[1] = java[2];
        net[0] = java[3];
        net[5] = java[4];
        net[4] = java[5];
        net[6] = java[7];
        net[7] = java[6];
        return encoder.encodeToString(net);
}