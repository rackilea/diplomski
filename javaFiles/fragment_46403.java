final List<String> areas = new ArrayList<String>();

for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
    String areaName = areaSnapshot.child("Value").getValue(String.class);
    areas.add(areaName);
}

for (String area : areas){
    if(area.equals("36")){
        jS36.setChecked(true);
    }
    if(area.equals("38")){
        jM38.setChecked(true);
    }
    // continue
}