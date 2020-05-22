public int getAsInt(int index) {
    switch (type) {
    case TIFF_BYTE: case TIFF_UNDEFINED:
        return ((byte[])data)[index] & 0xff;
    case TIFF_SBYTE:
        return ((byte[])data)[index];
    case TIFF_SHORT:
        return ((char[])data)[index] & 0xffff;
    case TIFF_SSHORT:
        return ((short[])data)[index];
    case TIFF_SLONG:
        return ((int[])data)[index];
    default:
        throw new ClassCastException();
    }
}