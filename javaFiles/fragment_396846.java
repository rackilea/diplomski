public StringBuilder preOrder(StringBuilder string) {
    string.append(value);
    string.append("(");
    if (left != null){
        left.preOrder(string);
    }
    if (right != null){
        right.preOrder(string);
    }
    string.append(")");
    return string;
}