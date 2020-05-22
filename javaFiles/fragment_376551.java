final DataHolder finalHolder = holder;

holder.cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 buttonView.setChecked(isChecked);
                 //Case1: Left (cb1) gets checked -> set all other right CB´s (cb2 & cb3) checked
                 if(isChecked){
                     finalHolder.cb2.setChecked(isChecked);  // NO MORE ERROR
                     finalHolder.cb3.setChecked(isChecked);  //NO MORE ERROR
                 }
             }
         });

holder.cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                buttonView.setChecked(isChecked);
                //Case2: Middle (cb2) gets checked -> set right CB (cb3) checked
                if(isChecked){
                    finalHolder.cb3.setChecked(isChecked);   // NO MORE ERROR
                }
                //Case3: Middle (cb2) gets unchecked -> set left CB (cb1) unchecked
                else {
                    finalHolder.cb1.setChecked(isChecked);   //NO MORE ERROR
                }
            }
        });