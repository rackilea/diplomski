public String myMethod() {
    StringBuilder sb = new StringBuilder();
    addToBuffer(sb, "Hello").addToBuffer("there,");
    addToBuffer(sb, "it").addToBuffer(sb, "works");
}

private StringBuilder addToBuffer(StringBuilder sb, String what) {
    return sb.append(what).append(' ');  // char is even faster here! ;)
}