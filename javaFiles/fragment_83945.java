caseX caseXObj = caseXBo.getCaseXDao().findCaseXBySID(selectedID);
if (caseXObj != null && caseXObj.getCaseInGrossAmt() != null) {
    // do something with caseXObj 
} else if (caseXObj == null) {
    // initialize caseXObj, you were misssing this case!
} else {
    caseXObj.setCaseAmt(BigDecimal.ZERO);
}