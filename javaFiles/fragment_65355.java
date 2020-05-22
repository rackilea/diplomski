HashMap<String, String> filterDevices = new HashMap<>();
if(!device_mac_list.contains(btMac)){
    device_mac_list.add(btMac);
//  stroing bluetooth deivce name in map with device name and mac address in key value pair
    filterDevices.put(btName, btMac);
    devicelist.add("Device: "+btName);
    arrayAdapter.notifyDataSetChanged();
}