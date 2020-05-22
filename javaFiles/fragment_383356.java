HashMap<String, List<SentinelReportModel>> hashmap = new HashMap<String, List<SentinelReportModel>>();


hashmap.put(,listeTemp);

for (int i = 0; i < sentinelReportModels.size(); i++) {
    if (hashMap.get(sentinelReportModels.get(i).getTypeflux())==null) {


ArrayList<SentinelReportModel> list = new ArrayList<SentinelReportModel>();
  list.add(sentinelReportModels.get(i));
hashMap.put(sentinelReportModels.get(i).getTypeflux(),list);
        }else {             hashMap.get(sentinelReportModels.get(i).getTypeflux()).add(sentinelReportModels.get(i));
        }
}