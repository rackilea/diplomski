Task<CountryDetails[]> fetchCountryTask = new Task<CountryDetails[]>() {
    @Override
    protected CountryDetails[] call() throws Exception {
        return GetCountries.getDetails();
    }
};

fetchButton.setOnAction(event -> new Thread(fetchCountryTask).start());

fetchCountryTask.setOnRunning(event -> cbCountryList.setDisable(true));

fetchCountryTask.setOnSucceeded(e -> {
    cbCountryList.getItems().addAll(fetchCountryTask.getValue());
    cbCountryList.setDisable(false);
});