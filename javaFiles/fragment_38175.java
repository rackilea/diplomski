@Override
public String toString() {
    if (this.front == null) return "";
    StringBuilder sb = new StringBuilder(length());
    node node = this.front;
    do sb.append(node.data);
    while ((node = node.next) != null);
    return sb.toString();
}