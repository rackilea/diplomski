string generateID(String valid, int length, Random r) {
    StringBuilder sb = new StringBuilder();
    while (sb.lengh() < length) {
        sb.append(valid.get(r.nextInt(valid.length()));
    }
    return sb.toString();
}