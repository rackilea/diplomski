public String Test3(List<Byte> byteList) {
    // find potential STX
    for (int i = 0; i < byteList.size(); ++i) {
        if (byteList.get(i) == STX) {
            // make sure matching ETX exists
            for (int j = i + 1; j < byteList.size(); ++j) {
                if (byteList.get(j) == ETX) {
                    return i;
                }
            }
        }
    }
}