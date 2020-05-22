boolean canAdd(Integer value) {
  Node current = this.node;
  while (current !=null) {
    if (current.value.equals(value)) {
      return false;
    }
    current = current.next;
  }
  return true;
}