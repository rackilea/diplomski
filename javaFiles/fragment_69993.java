IInfoObject myReport; // the WebI report you are trying to find the folder it is in
IInfoStore infoStore; // your gateway to the CMS database

// I'm not sure what info is in your myReport IInfoObject, so make sure we have what is needed
String infoStoreQuery = "select SI_ID,SI_NAME,SI_PARENTID from CI_INFOOBJECTS where SI_ID="+myReport.getID();
IInfoObjects infoObjects = infoStore.query(infoStoreQuery);

// because I used the ID there should be only 1 object in the infoObjects
IInfoObject myReportWithParentFolder = (IInfoObject)infoObjects.get(0);
int parentFolderId = myReportWithParentFolder.getParentID(); // ID of the folder that contains the report

// BEGIN now loop through the folders going backwards to get full path to the report
// loop not shown
infoStoreQuery = "select SI_ID,SI_NAME,SI_PARENTID from CI_INFOOBJECTS where SI_ID="+parentFolderId ;
infoObjects = infoStore.query(infoStoreQuery);
IInfoObject folder = (IInfoObject)infoObjects.get(0);
String folderName = folder.getTitle();
int parentFolderId = folder.getParentID(); 
// END loop area