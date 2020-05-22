spinnerProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int IDProvinces = getProvincesIDList.get(i);
        Toast.makeText(getContext(), "ID Province : " + IDProvinces, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});