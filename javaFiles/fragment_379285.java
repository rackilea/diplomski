public class FetchItemsTask extends AsyncTask<Void,Void,List<MovieItem>> {

    private final PhotoGalleryFragment outer;

    public FetchItemsTask(PhotoGalleryFragment outer, //a reference to the outer is passed in automatically
        String query) {
        this.outer = outer; //and stored in this FetchItemsTask instance
    }

    @Override
    protected void onPostExecute(List<MovieItem> items) {
        outer.setupAdapter(); //then used when outer methods are invoked
    }

}