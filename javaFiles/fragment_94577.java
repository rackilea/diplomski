viewHolder.chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int getPosition = (int) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
            //foodList.get(getPosition).setSelected(buttonView.isChecked()); // Set the value of checkbox to maintain its state.
            if (isChecked) {
                counter++;
            } else {
                counter--;
            }
            if (counter > 10) {
                buttonView.setChecked(false); // no need to do counter-- because the listener will trigger again
            }

        }
    });