class Countries {
  companion object {
    // it like static method in Java
    fun createSampleData(): ArrayList<CountryModel> {
        val countries = ArrayList<CountryModel>()
        countries.add(CountryModel("Afghanistan", "AF", "93"))
        countries.add(CountryModel("Albania", "AL", "355"))
        countries.add(CountryModel("Sudan", "SD", "249"))
        countries.add(CountryModel("Suriname", "SR", "597"))        
        return countries
    }
  }
}