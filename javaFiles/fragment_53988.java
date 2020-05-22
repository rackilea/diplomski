Map<String, AppData> AppDataHM = new HashMap<String, AppData>(); 
Map<String, Data> DataHM1 = new HashMap<String, Data>();

Map ADHMDHM = new HashMap<>();

Data data = DataHM.get(new AppDataRequest (id, email, password));
List<String> message = new ArrayList<>();

message.add("");
AppDataHM.put("AppData", new AppData("success", message));
DataHM1.put("Data", data);
ADHMDHM.putAll(AppDataHM);
ADHMDHM.putAll(DataHM1);
String ADHMDHM1 = new Gson().toJson(ADHMDHM);