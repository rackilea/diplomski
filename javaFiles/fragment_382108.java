String str = "SiteId:BLR232#Latitude:12.918444#Longitude:77.5940136#NetworkType:4g#Type:NONE#Type of Complaint:Call Drop#Sample Number:7022979575#Problem Description:agshjs vshsijsb#";
String[] kvps = str.split("#");
Map<String, String> res = new HashMap<String, String>();
for(String kvp : kvps) {
    String[] parts = kvp.split(":");
    res.put(parts[0], parts[1]);
    System.out.println(parts[0] + " - " + parts[1]); // just demo
}