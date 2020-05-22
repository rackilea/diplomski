public void trash(DriveId dId) {
  try {
    String fileID =  dId.getResourceId();
      if (fileID != null)
        _drvSvc.files().trash(fileID).execute();
  } catch (Exception e) {} 
}

public void delete(DriveId dId) {
  try {
    String fileID = dId.getResourceId();
      if (fileID != null)
        _drvSvc.files().delete(fileID).execute();
  } catch (Exception e) {} 
}