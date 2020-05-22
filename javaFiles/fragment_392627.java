@Override
public byte[] getBody() {
    try {
        return getJsonObject().toString().getBytes("utf-8");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return null;
    }
}