private void Load_City(int postion) {
        ArrayList<String> city_array = new ArrayList<String>();
        city_array.add(getString(R.string.city));



        for (int i = 0; i < items.getResponse().get(postion).getCities().size(); i++) {
            String get_city_name = items.getResponse().get(postion).getCities().get(i).getName();
            city_array.add(get_city_name);

        }

        ArrayAdapter<String> country_spinnerArrayAdapter = new adapter_spinner(getActivity(), R.layout.spinner_header, city_array);
        country_spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        binding.etCity.setAdapter(country_spinnerArrayAdapter);

        binding.etCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = parent.getSelectedItem().toString();
                if (position > 0) {
                    city_id = selectedItemText;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }