public class City{
    String cityName;
    public City(String cityName){
        this.cityName=cityName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String){
            return cityName.equals(obj);
        }
        return false;
    }
}

List<City> cities =  Lists.newArrayList(new City("New York"),new City("Chicago"));
Predicate<String> myCityPredicate = Predicates.equalTo("New York");
final List<City> res = Lists.newArrayList(Iterables.filter(cities , myCityPredicate));
//res.size() will be 1 and containing only your City("New York")
//To check whether it is present you can do :
final boolean isIn = Predicates.in(cities).apply("New York");