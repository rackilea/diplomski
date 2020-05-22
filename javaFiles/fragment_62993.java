final Spinner spinner = (Spinner)fragmentView.findViewById(R.id.spinner);
List<Map<String, String>> items = new ArrayList<Map<String, String>>();

Map<String, String> item0 = new HashMap<String, String>(2);
item0.put("text", "Browse aisles...");
item0.put("subText", "(Upgrade required)");
items.add(item0);

Map<String, String> item1 = new HashMap<String, String>(2);
item1.put("text", "Option 1");
item1.put("subText", "(sub text 1)");
items.add(item1);

Map<String, String> item2 = new HashMap<String, String>(2);
item2.put("text", "Option 2");
item2.put("subText", "(sub text 2)");
items.add(item2);

SimpleAdapter adapter = new SimpleAdapter(getActivity(), items,
        android.R.layout.simple_spinner_item, // This is the layout that will be used for the standard/static part of the spinner. (You can use android.R.layout.simple_list_item_2 if you want the subText to also be shown here.) 
        new String[] {"text", "subText"},
        new int[] {android.R.id.text1, android.R.id.text2}
);

// This sets the layout that will be used when the dropdown views are shown. I'm using android.R.layout.simple_list_item_2 so the subtext will also be shown.
adapter.setDropDownViewResource(android.R.layout.simple_list_item_2);

spinner.setAdapter(adapter);