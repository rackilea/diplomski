private ArrayList serviceNameList = new ArrayList();

serviceNameList.add("windows");
serviceNameList.add("linux");
serviceNameList.add("mac");

Map<String, Object> service = new HashMap<>();
service.put("full_name", full_name.getText().toString());
service.put("Services_names", serviceNameList);