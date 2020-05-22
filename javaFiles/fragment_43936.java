HashMap<Integer, String> record = new HashMap<Integer, String>();
String[] raw = line.split(",");
Boolean store = true;
for(int i=0;i<raw.length; i++){
    if(raw[i].equals("") || raw[i].equals(null)){
        store = false;
        break;
    }
    record.put(i, raw[i]);
}           
if(store)
    csvData.add(record);