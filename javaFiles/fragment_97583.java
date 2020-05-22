List<HashMap> dataBufferList = new ArrayList();

HashMap<String, Object> updates = new HashMap<>();

HashMap<String, String> data = new HashMap<>();
data.put("HR", ","80");
data.put("GPS","20.75,56.98");
data.put("Time", getCurrentTime(sdf)); 
dataBufferList.add(data);

for(int  i = 0 ; i < dataBufferList.size();++i){
    updates.put(myRef.push().getKey(), dataBufferList.get(i))
}
myRef.updateChildren(updates);
dataBufferList.clear();