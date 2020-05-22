// Employee.java

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumns({
    @JoinColumn(name="DIVISION_CODE", referencedColumnName="DIVISION_CODE", insertable=false, updatable=false),
    @JoinColumn(name="SURVEY_NUMBER", referencedColumnName="SURVEY_NUMBER", insertable=false, updatable=false)})
private Division division;

// Wow, now i expect i can change the value of DIVISION_CODE column
@Column(name="DIVISION_CODE")
private BigInteger divisionCode;