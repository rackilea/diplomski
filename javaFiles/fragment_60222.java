for (OperationDetail dtl : op.getOperationDetails()) {
    sum.setOpCond(true);
    if (dtl.getRelblkId() != null && dtl.getOperationsumRefId() != null && dtl.getOperationsumParentId() != null) {
        sum.setIsReliefOperation("Y");
        reliefOperationMap.put(dtl.getOperationsumId(), "Y");
    }
}