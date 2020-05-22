private static void transposeba(List<byte[]> m) {
    for (int i = 0; i < m.size(); i++) {
        for (int j = i; j < m.get(0).length; j++) {
            byte x = m.get(i)[j];
            m.get(i)[j] = m.get(j)[i];
            m.get(j)[i] = x;
        }
    }
}