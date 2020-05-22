private static final String INTENT_CLASSPACKAGE = "com.projecttango.tango";
private static final String INTENT_IMPORTEXPORT_CLASSNAME = "com.google.atap.tango.RequestImportExportActivity";
// startActivityForResult requires a code number.
private static final String EXTRA_KEY_SOURCEUUID = "SOURCE_UUID";
private static final String EXTRA_KEY_DESTINATIONFILE = "DESTINATION_FILE";
Intent exportIntent = new Intent();
exportIntent.setClassName(INTENT_CLASSPACKAGE, INTENT_IMPORTEXPORT_CLASSNAME);
exportIntent.putExtra(EXTRA_KEY_SOURCEUUID, mUUIDList[info.position]);
exportIntent.putExtra(EXTRA_KEY_DESTINATIONFILE, mAppSpaceADFFolder);
thisActivity.startActivityForResult(exportIntent, Tango.TANGO_INTENT_ACTIVITYCODE);