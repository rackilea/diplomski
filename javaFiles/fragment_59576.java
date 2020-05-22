public class CD {
    private String art;
    private String tit;
    private tracklist myTracklist; // declared

    public CD(String artist, String title){
        art = artist;
        tit = title;
        myTracklist = new tracklist(100); // initialized
    }

    // getter and setter methods of course.