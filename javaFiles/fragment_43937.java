ArrayList<Map<Integer, String>> csvData = new ArrayList<Map<Integer, String>>();

BufferedReader csvFile = new BufferedReader(new FileReader(new File(path)));
String line = "start";
int count = 0;
while((line = csvFile.readLine()) != null){
    if(count == 0){//skip first line
        count++;
        continue;
    }

    HashMap<Integer, String> record = new HashMap<Integer, String>();
    String[] raw = line.split(",");
    Boolean store = true;
    for(int i=0;i<raw.length; i++){
        if(raw[i].equals("") || raw[i].equals(null))
        {
            store = false;
            break;
        }
        record.put(i, raw[i]);
    }
    if(store)
        csvData.add(record);
    }   
csvFile.close();