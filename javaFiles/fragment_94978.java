public boolean setHistory(Params p){
    reimbursementHistory.setOldStatus(p.oldStatus);
    reimbursementHistory.setNewStatus(p.newStatus);
    reimbursementHistory.setAssignTo((String) reimbursementHistoryDetails.get(p.AssignTo));
    reimbursementHistory.setAssignne((String) reimbursementHistoryDetails.get(p.AssignNe));
}