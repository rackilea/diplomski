// Have this Map where you initialize the checkboxes(ie after you call `findViewById` to reference the checkboxes)
HashMap<String, CheckBox> checkBoxHashMap = new HashMap<>();
checkBoxHashMap.put("36", js36);
checkBoxHashMap.put("38", jM38);
// add all the checkboxes with the areaName

for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
    String areaName = areaSnapshot.child("Value").getValue(String.class);
    // To make sure areaName is a valid value in the Checkbox HashMap
    if(checkBoxHashMap.containsKey(areaName)){
        checkBoxHashMap.get(areaName).setChecked(true);
    }
}