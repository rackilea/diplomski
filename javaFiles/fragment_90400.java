if (folderInfoRecord.getValueRequired() && 
    Checker.isMissing(folderInfoData, folderInfoRecord) 
{
        showNotification(pageResourceBundle.getText("JS_ALERT_FIELD_REQUIRED"));
        return;
}