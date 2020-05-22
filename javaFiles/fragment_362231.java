DeviceInfo deviceInfo = deviceInfoDao.findByClientIdAndReasonCode(clientId, reasonCode);
if (deviceInfo == null) {
    deviceInfo = deviceInfoDao.save(deviceInfo);
} else {
    deviceInfo.setDeviceValue(deviceValue);
    deviceInfoDao.update(deviceInfo);
}