private void preparePlansData() {
    String plansData = plansPreferenceData.getString("plansPreferenceData", "");
    Type type = new TypeToken<Map<Integer, Plans>>(){}.getType();
    Map<Integer, Plans> myMap = gson.fromJson(plansData, type); 
    planList.addAll(myMap.values());

    // Notify data changes
    pAdapter.notifyDataSetChanged();
}