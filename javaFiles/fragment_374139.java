package com.mycompany.wms.module;

import com.wowza.wms.http.HTTProvider2Base;
import com.wowza.wms.http.IHTTPRequest;
import com.wowza.wms.http.IHTTPResponse;
import com.wowza.wms.logging.WMSLogger;
import com.wowza.wms.logging.WMSLoggerFactory;
import com.wowza.wms.vhost.IVHost;

public class SomeModule extends HTTProvider2Base {

public void onHTTPRequest(IVHost vhost, IHTTPRequest req, IHTTPResponse resp) {
    //Get the user
    String userId = req.getParameter("id");
    getLogger().info("Logging out user: " + userId );       

    logoutUser(userId);
}

private void logoutUser(String userId){
    //Do stuff here...
}

private WMSLogger getLogger(){
    return WMSLoggerFactory.getLogger(SomeModule.class);
}
}