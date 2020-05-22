private void initSpinner() {
        List<Data> listOfData = new ArrayList<>();
    listOfData.add(new Data(1,"Car"));
    listOfData.add(new Data(2,"Bus"));
    listOfData.add(new Data(3,"Bike"));  

        List<String> listOfNames = new ArrayList<>(); 
        for (Data data : listOfData) {  
         listOfNames.add(data.getName()); 
        }

        spinner.setItems(listOfNames); 
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() { 
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                   long selectedDataId = listOfData.get(position);
                   String selectedDataName = listOfNames.get(position); 
            }
        });
}