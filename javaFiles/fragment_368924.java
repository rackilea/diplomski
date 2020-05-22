public void setJsonResponse(String jsonResponse)
{
    this.jsonResponse=jsonResponse;
    //Create adapter object here
    result= RestUtil.getUserList(jsonResponse);
    adapter = new ArrayAdapter(...);
    ParamFactory.setParam("getHelperForService", adapter);
}