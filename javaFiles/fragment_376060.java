// Newly added variables, initialized in the constructor (or as appropriate)
private final StaffType      staffType;
private final StaffInformation staffInformation;
private final PayInformation payInformation;

...

public boolean isManagement() { return staffType.isManagement(); }
public boolean isExecutive() { return staffType.isExecutive(); }
public int getYearsOfService() { return staffInformation.getYearsOfService(); }
public Date getHireDate() { return staffInformation.getHireDate(); }
public int getDepartment() { return staffInformation.getDepartment(); }
public BigDecimal getBasePay() { return payInformation.getBasePay(); }
public BigDecimal getStockShares() { return payInformation.getStockShares(); }
public boolean hasStockSharePlan() { return payInformation.hasStockSharePlan(); }
...