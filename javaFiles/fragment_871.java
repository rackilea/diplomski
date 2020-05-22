public class MoviePresenter {
    public interface MovieReady {
        void onMoviesReady();
    }

    //...

    public MoviePresenter(Context mContext, RecyclerView movieRecycler) {
        mr = new MovieReadyImpl();
        //...
    }

    //...

    public class MovieReadyImpl implements MovieReady { //this is the equivalent to what you're doing. It just has a proper class name
         @Override
         public void onMoviesReady() {
             InitRecyclerView();
         }
    }
}