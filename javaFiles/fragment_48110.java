String last = "";
for (int i = 0; i < op.length - 1; i++) {
    if (!op[i].equals(last)) {
        help.add(op[i]);
    }
    last = op[i];
}