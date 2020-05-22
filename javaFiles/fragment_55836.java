// This is the inverse side, because it has the mappedBy attribute
// since it's mappedBy linf, hibernate uses the same mapping as the one
// described on the linf property: a join column
@OneToMany(mappedBy = "linf", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
public Set<MessageEntry> getMessageEntries() {
    return messageEntries;
}