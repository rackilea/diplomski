Node n = arr[obj.hashCode() % TABLE_SIZE];
while (n != null) {
    if(n.key.equals(obj)) return n.value;
    n = n.next;
}
return null;