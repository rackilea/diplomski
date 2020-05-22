@IndexedEmbedded
@ManyToOne
@JoinColumns(value = {
        @JoinColumn(name = "ITEM_CODE", referencedColumnName = "ITEM_CODE"),
        @JoinColumn(name = "ITEM_CODE_VERSION", referencedColumnName = "ITEM_CODE_VERSION")
})
private Item item;