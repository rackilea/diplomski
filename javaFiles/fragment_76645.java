public String toIndentedString() {
    StringBuilder sb = new StringBuilder(rootValue.toString());
    for (Tree<T> child : children) {
        sb.append('\n');
        sb.append(child.toIndentedString().replaceAll("(?m)^", "  "));
    }
    return sb.toString();
}