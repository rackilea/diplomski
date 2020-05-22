if (index == 0) {
    // insert new node at head
else {
    // Not inserting at head, so subtract 1 for "passing" head and continue
    recInsertHelper(index - 1, o, head);
}