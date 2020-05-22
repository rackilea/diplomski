APIBridge  bridge = APIBridge.getInstance();
    bridge.Initialize(midlet);
    NewFileService service = (NewFileService) bridge.createService("service.newfileservice");
    Hashtable filter = new Hashtable();
    filter.put("NewFileType", "Image");
  BridgeResult  res= service.TakePhoto(filter);