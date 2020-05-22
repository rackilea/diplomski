DeviceModel model = new DeviceModel();
DeviceModelId modelId = new DeviceModelId();
modelId.setModelNumber(654321);
// have to have a DeviceType to create a DeviceModel
model.setDeviceType(type);
model.setId(modelId);