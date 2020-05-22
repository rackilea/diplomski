int length = propositions.size();
if (length == 0) {
    main = "";
} else {
    StringBuilder sb = new StringBuilder();
    int nestingDepth = 0;
    // Reverse loop, ignoring 0th element due to special case
    for (int i = length - 1; i > 0; i--) {
        sb.append("|(").append(propositions.get(i)).append(',');
        nestingDepth++;
    }
    // Append last element due to special casing
    sb.append(propositions.get(0));
    for (int i = 0; i < nestingDepth; i++) {
        sb.append(')');
    }

    main = sb.toString();
}