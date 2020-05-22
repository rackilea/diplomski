for(int i=0;i<spinnerDataArraylocal.length;i++)
{
        String spinData = spinnerDataArraylocal[i];
        spinData = spinData.replaceAll("\"", "");
        String spinData[] = spinData.split(",");
        if(spinData[1].trim().equals("Premises Type"))
        {   
            String sample = spinData[1]+","+spinData[2]+","+spinData[3];
            premisesTypeArrayList.add(sample.toString().trim());            
            ArrayAdapter<String> adapterPremisesType = new ArrayAdapter<String>(
                    getActivity().getApplicationContext(),R.layout.custom_spinner,
                    premisesTypeArrayList);
            adapterPremisesType.setDropDownViewResource(R.layout.custom_spinner_item_list);
            spinnerPremisesType.setAdapter(adapterPremisesType);
            spinnerPremisesType.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                 public void onItemSelected(AdapterView<?> parent,  View view, int position, long id) {

                 }
                 @Override
                 public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
            adapterPremisesType.notifyDataSetChanged();
      }