groupList = new ArrayList<ListObj>();
while (cursor.moveToNext()) {

                int iD = cursor.getInt(cursor.getColumnIndex("ID"));
                String month = cursor.getString(cursor.getColumnIndex("Month"));
                double budget = cursor.getDouble(cursor.getColumnIndex("Budget"));
                groupList.add(new ListObj(iD,month,budget));
                createCollection();  // for child items
                if (expListAdapter != null) {
                    expListAdapter.add(iD, month, budget);
                    listview.setAdapter(expListAdapter);
                }
            }