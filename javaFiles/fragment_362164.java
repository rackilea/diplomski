public void add(Member member) {
    int size = members.size();
    members.add(member);
    fireTableRowsInserted(size, size);
}

public void remove(Member member) {
    int index = members.indexOf(member);
    if (index > -1) {
        members.remove(member);
        fireTableRowsDeleted(index, index);
    }
}