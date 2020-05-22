// CityOracle 
public class CityOracle extends SuggestOracle {

  Collection<CitySuggestion> collection;

  public CityOracle(Collection<CitySuggestion> collection) {
        this.collection = collection;
  }

  @Override
  public void requestSuggestions(Request request, Callback callback) {
    final Response response = new Response();

    response.setSuggestions(collection);
    callback.onSuggestionsReady(request, response);
  }

}



//CitySuggestion
public class CitySuggestion implements Suggestion, Serializable, IsSerializable {

    City value;

    public CitySuggestion(City value) {
        this.value = value;
    }

    @Override
    public String getDisplayString() {
        return value.getName();
    }

    @Override
    public String getReplacementString() {
        return value.getName();
    }

    public City getCity() {
        return value;
    }

}


 // Usage in your code:

// list of cities - you may take it from the server 
List<City> cities = new ArrayList<City>();
cities.add(new City(1l, "London"));
cities.add(new City(2l, "Berlin"));
cities.add(new City(3l, "Cracow"));

// revert cities into city-suggestions
Collection<CitySuggestion> citySuggestions = new ArrayList<CitySuggestion>();
for (City city : cities) {
    citySuggestions.add(new CitySuggestion(city));
}

//initialize city-oracle
CityOracle oracle = new CityOracle(citySuggestions);

// create suggestbox providing city-oracle     
SuggestBox citySuggest = new SuggestBox(oracle);

// now when selecting an element from the list, the CitySuggest object will be returned. This object contains not only a string value but also represents selected city
citySuggest.addSelectionHandler(new SelectionHandler<SuggestOracle.Suggestion>() {

    @Override
    public void onSelection(SelectionEvent<Suggestion> event) {
        Suggestion selectedItem = event.getSelectedItem();
        //cast returned suggestion
        CitySuggestion selectedCitySuggestion = (CitySuggestion) selectedItem;
        City city = selectedCitySuggestion.getCity();
        Long id = city.getId(); 
    }
});