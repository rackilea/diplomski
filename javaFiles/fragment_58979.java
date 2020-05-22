private static final long serialVersionUID = 1L;

private long operatorId;
private String operatorName;
private Date carTaskMoment;
private String carIncidenceTypeName;
private long amount;

public CarTaskByOperator(){
}

public CarTaskByOperator(final long operatorId, final String operatorName, final Date taskMoment, final String typeName, final long amount) {
    this.operatorId = operatorId;
    this.operatorName = operatorName;
    this.carTaskMoment = taskMoment;
    this.carIncidenceTypeName = typeName;
    this.amount = amount;
}
...
}