private boolean addDataCenterHost(String datacenter, String host) {
    Set<String> dataCenterHostSet = dataCenterHostsMap.get(datacenter);
    if(dataCenterHostSet == null) {
        dataCenterHostSet = new HashSet<String>();
        dataCenterHostsMap.put(datacenter, dataCenterHostSet);
    }
    return dataCenterHostSet.add(host);
}