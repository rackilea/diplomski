@Table(name="TABLE_NAME", uniqueConstraints = {
@UniqueConstraint(columnNames={"advisorName", "advisorNameParent", "advisorPost", "percentage", "diffPercentage" , "saleAmount", "saleCount", "commissionAmount" })

@Column(name = "ADVISOR_NAME", length=100)
private String advisorName;
private String advisorCodeParent;
@Column(name = "ADVISOR_PARENT_NAME", length=100)
private String advisorNameParent;
@Column(name = "ADVISOR_POST" , length=100)
private String advisorPost;
@Column(name = "PERCENTAGE")
private Double percentage;
@Column (name = "DIFF_PERCENTAGE")
private Double diffPercentage;
@Column (name = "SALE_AMOUNT")
private Double saleAmount;
@Column (name = "SALE_COUNT")
private Long saleCount;
@Column (name = "COMMISSION_AMOUNT")
private Double commissionAmount;