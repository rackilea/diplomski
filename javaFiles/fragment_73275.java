interface InfoLoader {
    RatingInfo loadRatingInfo();
    CustomerInfo loadCustomerInfo();
    MovieInfo loadMovieInfo();
}

class FileInfoLoader implements InfoLoader {
    public RatingInfo loadRatingInfo() {
        FileParser ratingsFile = new FileParser("ratings.dat", "::");
        RatingsMapper ratingsMapper = new RatingsMapper(ratingsFile, 4);
        return new RatingInfo(ratingsMapper.getCustomerIDMovieIDRatingAndTimeMap());
    }
    public CustomerInfo loadCustomerInfo () {
        FileParser customerFile = new FileParser("users.dat", "::");
        CustomerMapper customerMapper = new CustomerMapper(customerFile, 5);
        return new CustomerInfo(customerMapper.getIdCustomerMap());
    }
    public MovieInfo loadMovieInfo () {
        FileParser movieFile = new FileParser("movies.dat", "::");
        MovieMapper movieMapper = new MovieMapper(movieFile, 3);
        return new MovieInfo(movieMapper.getIdMovieMap());
    }
}

class App {
    public App(InfoLoader infoLoader) {
        this.infoLoader = infoLoader;
    }
    public void start() {
        Statistics stat = new Statistics(
            infoLoader.loadCustomerInfo(),
            infoLoader.loadMovieInfo(),
            infoLoader.loadRatingInfo()
        );
        DisplayStatistics ds = new DisplayStatistics(stat);
        UserInterface ui = new UserInterface(ds);
        ui.start();
    }
    private InfoLoader infoLoader;
}

public class Application {
    public static void main(String[] args) {
        InfoLoader infoLoader = new FileInfoLoader();
        // or InfoLoader infoLoader = new SqlInfoLoader();
        App app = new App(infoLoader);
        app.start();
    }
}