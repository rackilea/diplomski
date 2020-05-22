for (int i = 0; i < setOfCheckBoxes.length; i++) {
    final int index = i;
    setOfCheckBoxes[i].setOnClickListener(new View.OnClickListener(){    
        public void onClick(View v) {      
            selected[index] = ((CheckBox) v).isChecked();
        }
    });
}