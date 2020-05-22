ArrayList<String> arrayList1 = new ArrayList<>();

arrayList1.add("a");
arrayList1.add("b");
arrayList1.add("c");
arrayList1.add("d");

spinner_adapter sAdapter = new SpinnerAdapter(this, arrayList1);

spinner.setAdapter(sAdapter);
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selection = arrayList1.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});