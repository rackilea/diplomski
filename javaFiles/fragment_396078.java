ArrayList<HashMap<String, String>> listItems = new ArrayList<>();
HashMap<String, String> listItemData;

for (int i=0; i<results.size(); i++) {

    if (results.size() != 0) {
        listItemData = new HashMap<String, String>();
        String resultStr = results.get(i).toString();
        String[] resultStrVar = resultStr.split(",");

        listItemData.put("disease_name", resultStrVar[0]);
        listItemData.put("confidence", resultStrVar[1]);
        listItems.add(listItemData);

    } else {
        listItemData = new HashMap<String, String>();
        listItemData.put("disease_name", "No predictions found");
        listItemData.put("confidence", "Kindly shot again");
        listItems.add(listItemData);
    }
}

SimpleAdapter adapter = new SimpleAdapter(Results.this, listItems,
        android.R.layout.simple_list_item_2,
        new String[] {"disease_name", "confidence"},
        new int[] {android.R.id.text1, android.R.id.text2 });

listView.setAdapter(adapter);