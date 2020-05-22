IConnectionInfo oldConnInfo = new ConnectionInfo();
IConnectionInfo newConnInfo = new ConnectionInfo();

// If this connection needed parameters, we would use this field.   
com.crystaldecisions.sdk.occa.report.data.Fields pFields = null;

try{
    // Assign the old Connection info to the reports current info
    //DatabaseController dbController = rptClient.getDatabaseController();
    oldConnInfo=dbController.getConnectionInfos(null).getConnectionInfo(0);
    com.crystaldecisions.sdk.occa.report.lib.PropertyBag boPropertyBag1 = new com.crystaldecisions.sdk.occa.report.lib.PropertyBag();
    boPropertyBag1.put("JDBC Connection String","...");
    boPropertyBag1.put("Server Type","...");
    boPropertyBag1.put("Database Type","...");
    boPropertyBag1.put("Database Class Name","...");
    boPropertyBag1.put("Use JDBC","...");
    boPropertyBag1.put("Connection URL","...");
    boPropertyBag1.put("Database DLL","...");
    // Assign the properties to the connection info
    newConnInfo.setAttributes(boPropertyBag1);
    // Set the DB Username and Pwd
    newConnInfo.setUserName("...");
    newConnInfo.setPassword("...");    
    // The Kind of connectionInfos is SQL
    newConnInfo.setKind(ConnectionInfoKind.SQL);

    // set the parameters to replace.
    // The 4 options are:
    // _doNotVerifyDB 
    // _ignoreCurrentTableQualifiers 
    // _mapFieldByRowsetPosition 
    // _useDefault  
    int replaceParams = DBOptions._ignoreCurrentTableQualifiers + DBOptions._doNotVerifyDB;
    // Now replace the connections
    dbController.replaceConnection(oldConnInfo, newConnInfo, pFields, replaceParams);
    }catch(ReportSDKException rse){
    ...
    }