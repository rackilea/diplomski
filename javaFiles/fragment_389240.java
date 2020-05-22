public HashMap<String, ArrayList<String>> iPsForDays(){
    HashMap<String, ArrayList<String>> mapDatesToIPs = new HashMap<String,ArrayList<String>>();

    for(LogEntry le : records){
        Date d = le.getAccessTime();
        String dates = d.toString().substring(4, 10);//date is a diff format
        if(!mapDatesToIPs.containsKey(dates)){
            /* Move Here */
            ArrayList<String> ips = new ArrayList<String>();
            ips.add(le.getIpAddress());
            mapDatesToIPs.put(dates, ips);
        }
        else if(mapDatesToIPs.containsKey(dates)){
            String ip = le.getIpAddress();
            /* Retrieve List */
            ArrayList<String> ips = mapDatesToIPs.get(dates);
            ips.add(ip);
        }
    }
    return mapDatesToIPs;       
}