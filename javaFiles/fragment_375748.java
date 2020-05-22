private static final Map<Byte, MessageType> byteToEnum = new HashMap<Byte, MessageType>();

static { // Initialize map from byte value to enum constant
  for (MessageType type : values())
    byteToEnum.put(type.getValue(), type);
}

// Returns MessageType for byte, or null if byte is invalid
public static MessageType fromByte(Byte byteValue) {
  return byteToEnum.get(byteValue);
}