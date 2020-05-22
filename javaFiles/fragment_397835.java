public String Test3(List<Byte> byteList) {
    // find potential ETX
    for (int i = byteList.size() - 1; i > 0; --i) {
        if (byteList.get(i) == ETX) {
            // make sure matching STX exists
            for (int j = i - 1; j > 0; --j) {
                if (byteList.get(j) == STX) {
                    return j;
                }
            }
        }
    }
}