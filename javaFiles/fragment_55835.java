// This is the owner side of the association, because it doesn't have 
// the mappedBy attribute.
// it uses a join column by default
@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
public Linf getLinf() {
    return linf;
}