// Map relationships directly to objects instead of using integer primary keys
    @JoinColumns({@JoinColumn(name = "IndexTemplateId", referencedColumnName = "IndexTemplateId", insertable = false, updatable = false), @JoinColumn(name = "FieldNumber", referencedColumnName = "FieldNumber", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Field field;
    @JoinColumn(name = "SearchRuleId", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SearchRule searchRule;