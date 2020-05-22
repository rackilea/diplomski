@Override
public String getHead(Handler h) {
    boolean writeHeader = true;
    try {
        if (h instanceof FileHandler) {
            writeHeader = lengthOpen((FileHandler) h).longValue() == 0L;
        }
    } catch (SecurityException ignore) {
    }

    if (writeHeader) {
        return ""; //TODO: Insert your CSV headers.
    } else {
        return super.getHead(h); //Skip headers.
    }
}

private Number lengthOpen(Handler h) {
    if (h instanceof FileHandler) {
        String p = h.getClass().getName();
        LogManager manager = LogManager.getLogManager();
        p = manager.getProperty(p.concat(".pattern"));
        //TODO: Deal with FileHandler patterns.
        if (p != null) {
            File f = new File(p);
            //TODO: Implement file listing and filtering.
            return f.length();
        }
    }
    return 0L;
}