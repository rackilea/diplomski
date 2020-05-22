ArrayAdapter<String> country_spinnerArrayAdapter = new adapter_spinner(getActivity(), R.layout.spinner_header, country_array);
                                    country_spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                                    binding.etCountry.setAdapter(country_spinnerArrayAdapter);
                                    binding.etCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            String selectedItemText = parent.getSelectedItem().toString();
                                            if (position > 0) {
                                                country_id = selectedItemText;
                                                city_id = "";
                                                Load_City(position - 1); // -1 to remove postion of the static country text
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {
                                        }
                                    });