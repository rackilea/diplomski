private void setSpinnerData(Spinner spinner,String... params){
        List<String> spinnerArray =  new ArrayList<String>();

        for(String str:params){
            spinnerArray.add(str);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
}