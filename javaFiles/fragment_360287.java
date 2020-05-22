public class DatacenterMachineMapping {

    private boolean firstCall = true;
    private int hostListIndex = 0;
    private List<String> datacenterList, hostList;

    public DatacenterMachineMapping(List<String> datacenterList, List<String> hostList) {
        this.datacenterList = datacenterList;
        this.hostList = hostList;
    }

    public Map<String, String> getDatacenterMachineMapping() {
        Map<String, String> datacenterMachineMapping = new HashMap<>();
        if(! firstCall) {
            if(hostListIndex == 0) {
                hostListIndex = hostList.size();
            }
            hostListIndex--;
        } else {
            firstCall = false;
        }
        for(String datacenter : datacenterList) {
            if(hostListIndex == hostList.size()) {
                hostListIndex = 0;
            }
            datacenterMachineMapping.put(datacenter, hostList.get(hostListIndex++));
        }
        hostListIndex--;
        return datacenterMachineMapping;
    }
}