public void displayCities(List<CityResponse.City> cities) {
        for (CityResponse.City city : cities) {
            spinnerItem.add(city.getNama());
        }
        // 2. notify adapter that you have inserted new cities to the list
}

private void setSpinner(){
        // 1. set the adapter with spinnerItem which is empty here
        ArrayAdapter<String> adapter = new ArrayAdapter<>(..., ..., spinnerItem);
        mainBinding.spinnerCity.setAdapter(adapter);
        ...
}