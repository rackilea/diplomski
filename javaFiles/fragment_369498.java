@Override
public String getHead(Handler h) {
    boolean writeHeader = true;
    try {
        if (h instanceof FileHandler) {
            writeHeader = lengthFrom((FileHandler) h).longValue() == 0L;
        }
    } catch (SecurityException ignore) {
    }

    if (writeHeader) {
        return ""; //TODO: Insert your CSV headers here.
    } else {
        return super.getHead(h); //Skip headers.
    }
}

private Number lengthFrom(FileHandler h) {
    try {
        Field f = StreamHandler.class.getDeclaredField("output");
        f.setAccessible(true);
        OutputStream out = (OutputStream) f.get(h);
        f = out.getClass().getDeclaredField("written");
        f.setAccessible(true);
        return (Number) f.get(out);
    } catch (ReflectiveOperationException roe) {
        h.getErrorManager().error(null, roe, ErrorManager.FORMAT_FAILURE);
    }
    return 0L;
}