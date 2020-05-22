@ManyToOne
@JoinColumns({
    @JoinColumn(name="site", referencedColumnName="site", insertable = false, updatable = false),
    @JoinColumn(name="primary_category_id", referencedColumnName="category_id", insertable = false, updatable = false)
})
private Category primaryCategory;

@ManyToOne
@JoinColumns({
    @JoinColumn(name="site", referencedColumnName="site", insertable = false, updatable = false),
    @JoinColumn(name="secondary_category_id", referencedColumnName="category_id", insertable = false, updatable = false)
})
private Category secondaryCategory;