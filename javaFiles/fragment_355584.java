public class UserLogin {

public int objMobileCapabilityId;
public int objMobileCapabilityValue;
public String objMobileCapabilityDesc;
public int objMobileDisplayOrder;

public UserLogin(){}

public UserLogin(int objmobilecapabilityid, int objmobilecapabilityvalue, String objmobilecapabilitydesc, int objmobiledisplayorder) {

    objMobileCapabilityId = objmobilecapabilityid;
    objMobileCapabilityValue = objmobilecapabilityvalue;
    objMobileCapabilityDesc = objmobilecapabilitydesc;
    objMobileDisplayOrder = objmobiledisplayorder;
}

public int getObjMobileCapabilityId() {
    return objMobileCapabilityId;
}

public int getObjMobileCapabilityValue() {
    return objMobileCapabilityValue;
}

public String getObjMobileCapabilityDesc() {
    return objMobileCapabilityDesc;
}

public int getObjMobileDisplayOrder() {
    return objMobileDisplayOrder;
}
}