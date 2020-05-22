@Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
            String carBrand = parent.getSelectedItem().toString();
            if (carBrand.equals("Nissan")) {
                final Spinner model = (Spinner) findViewById(R.id.model);
                String[] models = new String[]{"S14", "R34", "240SX"};
                ArrayAdapter<String> modeladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, models);
                model.setAdapter(modeladapter);

            } else if (carBrand.equals("Honda")) {
                Spinner model = (Spinner) findViewById(R.id.model);
                String[] models = new String[]{"Civic", "NSX", "Accord"};
                ArrayAdapter<String> modeladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, models);
                model.setAdapter(modeladapter);
            } else if (carBrand.equals("Toyota")) {
                Spinner model = (Spinner) findViewById(R.id.model);
                String[] models = new String[]{"Supra", "AE86", "GT86"};
                ArrayAdapter<String> modeladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, models);
                model.setAdapter(modeladapter);
            }
        }