String[][] takin = new String[array.length()][3]
for (int i = 0; i < array.length(); i++) {
    JSONObject allClass = array.getJSONObject(i);
    takin[i] = new String[]{allClass.getString("numb"),
                        allClass.getString("name"),
                        allClass.getString("time")};

}
tableView.setDataAdapter(new SimpleTableDataAdapter(AttendanceActivity.this, Collections.singletonList(takin)));