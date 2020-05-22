public static void main(String[] args) {
    String genre = "Action, Animation, Comdey";
    String[] genres = genre.split(", ");
    for (int i = 0; i < (genres.length) - 1; i++) {
        System.out.println(genres[i]);
        if (!genres[i].equals("Action") && !genres[i].equals("Adventure") && !genres[i].equals("Animation")
                && !genres[i].equals("Biography") && !genres[i].equals("Comedy") && !genres[i].equals("Crime")
                && !genres[i].equals("Documentary") && !genres[i].equals("Drama") && !genres[i].equals("Family")
                && !genres[i].equals("Fantasy") && !genres[i].equals("Film-Noir") && !genres[i].equals("Game-Show")
                && !genres[i].equals("History") && !genres[i].equals("Horror") && !genres[i].equals("Music")
                && !genres[i].equals("Musical") && !genres[i].equals("Mystery") && !genres[i].equals("News")
                && !genres[i].equals("Reality-TV") && !genres[i].equals("Sci-Fi") && !genres[i].equals("Sport")
                && !genres[i].equals("Talk-Show") && !genres[i].equals("Thriller") && !genres[i].equals("War")
                && !genres[i].equals("Western")) {
            System.out.println("Selected genres could not be identified");
            return;
        } else {
            System.out.println("Success");
        }
    }
}