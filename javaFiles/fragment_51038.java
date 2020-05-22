public class User implements Parcelable{

        private String email;
        private String user_id;
        private String username;
        private String avatar;
        private List<Integer> stops;
        private ClassLoader classLoader;


        public User(String email, String user_id, String username, String avatar, List<Integer> stops, ClassLoader classLoader) {
            this.email = email;
            this.user_id = user_id;
            this.username = username;
            this.avatar = avatar;
            this.stops = stops;
            this.classLoader = classLoader;
        }


    public List<Integer> getStops() {
        return stops;
    }

    public void setStops(List<Integer> stops) {
        this.stops = stops;
    }
}