...
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "parent_id")
public Region getParent() {
    return parent;
}
...