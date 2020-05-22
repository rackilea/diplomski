btnCheckAll.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        boolean toCheck=true;

        //THE CONDITION SHOULD BE OUTSIDE THE LOOP!

 if(btnCheckAll.getText().toString().equalsIgnoreCase("Select All")) {
            toCheck=true;
            btnCheckAll.setText("Clear All");
        }


            else if (btnCheckAll.getText().toString().equalsIgnoreCase("Clear All")){
                    toCheck=false;
            btnCheckAll.setText("Select All");


        }



        int count = MatchingContactsAsArrayList.size();
        for (int i = 0; i < count; i++) {
        LinearLayout itemLayout = (LinearLayout) listView.getChildAt(i); // Find by under LinearLayout
        CheckBox checkbox = (CheckBox) itemLayout.findViewById(R.id.checkBoxContact);
        checkbox.setChecked(toCheck);
    }}
});