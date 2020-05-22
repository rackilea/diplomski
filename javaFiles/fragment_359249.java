java.util.Base64.Encoder encoder= Base64.getEncoder();
UUID uuid = UUID.fromString("be9f1bb6-5c8e-407d-85a3-d5ef31f21b4d");
ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
bb.putLong(uuid.getMostSignificantBits());
bb.putLong(uuid.getLeastSignificantBits());

byte[] uuid_bytes = bb.array();
byte[] guid_bytes = Arrays.copyOf(uuid_bytes,uuid_bytes.length);

guid_bytes[0] = uuid_bytes[3];
guid_bytes[1] = uuid_bytes[2];
guid_bytes[2] = uuid_bytes[1];
guid_bytes[3] = uuid_bytes[0];
guid_bytes[4] = uuid_bytes[5];
guid_bytes[5] = uuid_bytes[4];
guid_bytes[6] = uuid_bytes[7];
guid_bytes[7] = uuid_bytes[6];

String result = encoder.encodeToString(guid_bytes);