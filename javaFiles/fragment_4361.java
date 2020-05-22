/**
 * Writes non-proxy class descriptor information to given output stream.
 */
void writeNonProxy(ObjectOutputStream out) throws IOException {
    out.writeUTF(name);
    out.writeLong(getSerialVersionUID());

    byte flags = 0;
    if (externalizable) {
        flags |= ObjectStreamConstants.SC_EXTERNALIZABLE;
        int protocol = out.getProtocolVersion();
        if (protocol != ObjectStreamConstants.PROTOCOL_VERSION_1) {
            flags |= ObjectStreamConstants.SC_BLOCK_DATA;
        }
    } else if (serializable) {
        flags |= ObjectStreamConstants.SC_SERIALIZABLE;
    }
    if (hasWriteObjectData) {
        flags |= ObjectStreamConstants.SC_WRITE_METHOD;
    }
    if (isEnum) {
        flags |= ObjectStreamConstants.SC_ENUM;
    }
    out.writeByte(flags);

    out.writeShort(fields.length);
    for (int i = 0; i < fields.length; i++) {
        ObjectStreamField f = fields[i];
        out.writeByte(f.getTypeCode());
         out.writeUTF(f.getName());
        if (!f.isPrimitive()) {
            out.writeTypeString(f.getTypeString());
        }
    }
}