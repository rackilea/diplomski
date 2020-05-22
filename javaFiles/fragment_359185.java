// store the current payment info
reportDataSubList = new ArrayList<String>();
reportDataSubList.add(clientCode);
//...                                   
reportDataList = reportData.get(clientCode);
if(reportDataList == null){
    reportDataList = new ArrayList<List<String>>();
    reportData.put(clientCode, reportDataList);
}
reportDataList.add(reportDataSubList);