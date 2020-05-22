Response response = new Search("La+vereda+de+la+puerta+de+atras").execute();
List<Result> results = response.getResults();

if (results != null && results.size() > 0) {
    for(Result result : results) {
        System.out.println(result.getArtistName().toString());
    }
} else {
    System.out.println("No results found :(");
}