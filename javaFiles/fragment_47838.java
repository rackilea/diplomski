spinner. setOnItemSelectedListener(new MyOnItemSelectedListener());


class MyOnItemSelectedListener implements OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent,
        View view, int pos, long id) {
        String choice = parent.getItemAtPosition(pos).toString();
            populateSecondSpinnerMethod(choice)
       }
    }
    public void onNothingSelected(AdapterView parent) {       // Do nothing.
    }
}