if(btnCheckAll.getText().toString().equalsIgnoreCase("Select All")) {//This condition will be true on first round and 3 and 5 and 7...
            checkbox.setChecked(true);
            btnCheckAll.setText("Clear All");
        }


            else if (btnCheckAll.getText().toString().equalsIgnoreCase("Clear All")){//And this one will be true in 2 and 4 and 6...
                    checkbox.setChecked(false);
            btnCheckAll.setText("Select All");