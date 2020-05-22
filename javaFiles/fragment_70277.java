@SkipValidation
public String editControlParameter() throws Exception{

    ControlParameterData data = ((ControlParameterData) getData());

    UserIdentificationToken userId = getUserIdentificationToken(getServletRequest());
    ControlParameterData d = controlParameterService.findControlParameterByPK(data.getId(), userId);
    d.setValue(data.getValue());
    ControlParameterData createdData = controlParameterService.modifyControlParameter(d, userId);
    setDataParameters(d, createdData);
    return SUCCESS;
}