public void onClick(DialogInterface dialogInterface, int i) {
                String getSubjectInput = input.getText().toString();
                storedList.add(getSubjectInput);
                tinyDB.putListString("storedList1stYr2", storedList);

                generalList.add(getSubjectInput);
                arrayAdapter.notifyDataSetChanged();
            }