public class MyService {

    private MyDAO myDAO;

    public MySErvice(MyDAO myDAO) {
        this.myDAO = myDAO;
    }

    public List<City> getRandomCityList() {
        List<Country> countries = myDAO.getCountries();
        Country c = pickRandom(countries);
        return myDAO.getCities(country);
    }
}