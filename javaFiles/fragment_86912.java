if (result != null && result.getDevice() != null && result.getDevice().getAddress() != null) {
            if (null != mOnDeviceScanListener) {
                BleDeviceData data = new BleDeviceData();
                data.setDeviceName(result.getDevice().getName() != null ? result.getDevice().getName() : "Unknown");
                data.setDeviceAddress(result.getDevice().getAddress());
                boolean isSame = false;
                for (BleDeviceData deviceData : mDeviceList) {
                    if (deviceData.getDeviceAddress().equalsIgnoreCase(data.getDeviceAddress())) {
                        // Neglect the ID
                        isSame = true;
                    }
                }
                if (!isSame) {
                    mDeviceList.add(data);
                }
            }
        }
    }