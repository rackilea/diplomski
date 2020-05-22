private String subtreeToString(BTNode r) {
    String str = "";
    if(r == null) {
        return str;
    }
    str += r.item;
    str += " (" + subtreeToString(r.left) + ") (" + subtreeToString(r.right) + ")";
    return str;
}