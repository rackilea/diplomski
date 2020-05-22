File isoFile = new File("myimage.iso");

IDiscMaster2 dm = ClassFactory.createMsftDiscMaster2();
int count = dm.count();

//Pick the first recorder on the system
String recorderUniqueId = null;
for (int i = 0; i < count; i++)
{
    String cur = dm.item(i);
    recorderUniqueId = cur;
}

IDiscRecorder2 recorder = ClassFactory.createMsftDiscRecorder2();
recorder.initializeDiscRecorder(recorderUniqueId);
System.out.println("Using recorder: " + recorder.vendorId() + " " + recorder.productId());

IIsoImageManager imageManager = StreamClassFactory.createMsftIsoImageManager();
imageManager.setPath(isoFile.getAbsolutePath());
imageManager.validate();
System.out.println("ISO Validation successful: " + isoFile.getAbsolutePath());

IDiscFormat2DataExt discData = ClassFactoryExt.createMsftDiscFormat2Data();
discData.recorder(recorder);
discData.clientName(IsoMan.class.getSimpleName());
int mediaStatus = discData.currentMediaStatusExt();
System.out.println("Media status: " + mediaStatus);
if ((mediaStatus & IMAPI_FORMAT2_DATA_MEDIA_STATE.IMAPI_FORMAT2_DATA_MEDIA_STATE_WRITE_PROTECTED.comEnumValue()) != 0)
    throw new RuntimeException("Media is write protected / not empty.");

//Check if disc is empty
int addr = discData.nextWritableAddress();
if (addr != 0)
    throw new RuntimeException("Disc is not empty, not writing.");

IStream isoStream = imageManager.stream();

System.out.println("Writing CD");
discData.write(isoStream);
System.out.println("Finished writing");