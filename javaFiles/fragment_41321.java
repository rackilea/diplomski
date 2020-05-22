public Map<Integer, DeviceTypes> filterByName(String text)
    {
        return  deviceTypesTable.entrySet().stream()
                .filter(deviceType->deviceType.getValue().getName().contains(text))
                .collect(Collectors.toMap(deviceType -> deviceType.getKey(), deviceType -> deviceType.getValue())); 
    }