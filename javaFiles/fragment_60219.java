for (int d = 0; d < op.getOperationDetails().size(); d++) {
    OperationDetail dtl = op.getOperationDetails().get(d);
    if (dtl.getOpStatId() == 1 || dtl.getOpStatId() == 3 || dtl.getOpStatId() == 4) {
        sum.setOpCond(true);
        if (dtl.getRelblkId() != null && dtl.getOperationsumRefId() != null && dtl.getOperationsumParentId() != null) {
            sum.setIsReliefOperation("Y");
            reliefOperationMap.put(dtl.getOperationsumId(), "Y");
        }
    } else {
        if (dtl.getRelblkId() != null && dtl.getOperationsumRefId() != null && dtl.getOperationsumParentId() != null) {
            sum.setOpCond(true);
            sum.setIsReliefOperation("Y");
            reliefOperationMap.put(dtl.getOperationsumId(), "Y");
        } else {
            sum.setOpCond(true);
        }
    }
}