CheckBox box = (CheckBox) findViewById(R.id.chk_box);
box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           // either you can save the selection list in array list andupdate your main display layout after the dialog is closed . or Update the display layout on  every time check state changes.
                if(isChecked) {
                   // save the selection list in array list
                    arrayList.add(buttonView.getText());
                   // or else update the display layout.
                   textview.setText(buttonView.getText());
                } else {
                    arrayList.remove(buttonView.getText());
                   // update layout
                   textview.setText(buttonView.getText());
                }
            }
        });