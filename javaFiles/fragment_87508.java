String sessionID = "sampleID";
ResourceContextDef rcd = //whatever it needs to be equal to
AttributeList requestAttributeList = new AttributeList();
AttributeList responseAttributeList = new AttributeList();

if(getSessionVariables(sessionId, rcd, requestAttributeList, responseAttributeList) == YES){
    Attribute att = responseAttributeList.getAttributeAt(0);//or whatever index. 
}