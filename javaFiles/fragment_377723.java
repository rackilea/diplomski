@Produces @CaseContext
public CaseDTO getContextCase()  {
    return JSFUtils.getFromPageFlowScope("case", CaseDTO.class);
}

@Produces @CaseContext("ip")
public IPCaseDTO getContextIpCase()  {
    return JSFUtils.getFromPageFlowScope("case", IPCaseDTO.class);
}

@Produces @CaseContext("group")
public GroupCaseDTO getContextGroupCase()  {
    return JSFUtils.getFromPageFlowScope("case", GroupCaseDTO.class);
}