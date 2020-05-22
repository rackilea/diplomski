for (int d = 0; d < op.getOperationDetails().size(); d++) {
    OperationDetail dtl = op.getOperationDetails().get(d);
    sum.setOpCond(true);
    if (dtl.getRelblkId() != null && dtl.getOperationsumRefId() != null && dtl.getOperationsumParentId() != null) {
        sum.setIsReliefOperation("Y");
        reliefOperationMap.put(dtl.getOperationsumId(), "Y");
    }
}