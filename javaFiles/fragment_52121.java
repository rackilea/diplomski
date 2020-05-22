private Map<Integer, byte[]> map = new HashMap<>();
[...]
void addChar(String mark, CMapObject code) {
    if (code.isNumber()) {
        byte[] ser = decodeStringToByte(mark);
        map.put((int)code.getValue(), ser);
    }
}