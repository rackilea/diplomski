@ManyToOne(fetch=FetchType.LAZY)
@JoinColumns({
    // I can be updatable
    @JoinColumn(name="DIVISION_CODE", referencedColumnName="DIVISION_CODE", insertable=false),
    // And i can be insertable
    @JoinColumn(name="SURVEY_NUMBER", referencedColumnName="SURVEY_NUMBER", updatable=false)})
private Division division;