needsInfoList = new ArrayList<>();
needsInfoView = (ListView) findViewById(R.id.needsInfo);

  for (int i = 0; i < 11; i++) {
       HashMap<String, String> needsInfoHashMap = new HashMap<>();
       needsInfoHashMap.put("TA", needsTitleArray[i]);
       needsInfoHashMap.put("IA", needsInfoArray[i]);
       needsInfoList.add(needsInfoHashMap);
   }
   needsInfoAdapter = new SimpleAdapter(getBaseContext(), needsInfoList,
                R.layout.needsinfocontent, new String[]{"TA", "IA"},
                new int[]{R.id.ta, R.id.ia});
   needsInfoView.setVerticalScrollBarEnabled(true);
   needsInfoView.setAdapter(needsInfoAdapter);