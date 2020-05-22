// Employee.java

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumns({
    @JoinColumn(name="DIVISION_CODE", referencedColumnName="DIVISION_CODE"),
    @JoinColumn(name="SURVEY_NUMBER", referencedColumnName="SURVEY_NUMBER", insertable=false, updatable=false)})
private Division division;