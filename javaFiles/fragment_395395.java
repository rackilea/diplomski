for (int x = 1; x <= someUpperLimit; x++) {
    StringBuilder sb = new StringBuilder();
    for (int y = 1; y <= someUpperLimit; y++) {
        if (y != x) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(y);
        }
    }
    out.write(sb.toString());
}