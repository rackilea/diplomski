businessTypeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView , View view , int position , long l) {
                }

    StateCityModel stateCityModel = new StateCityModel();
    stateCityModel = clubsList.get(position);;

    if (!selectedBusinessTypeList.contains(stateCityModel)){
         selectedBusinessTypeList.add(stateCityModel);
    }

}