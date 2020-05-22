public class ArtistImage {
    public String image;
    public String name;
}

public class LoadImages extends AsyncTask<String, Integer, List<ArtistImage>> {
    private List<ArtistImage> artistImages = new ArrayList<ArtistImage>();
    private ArtistAdapter artistAdapter;

    public LoadImages(ArtistAdapter adapter) {
        artistAdapter = adapter;
    }

    @Override
    protected List<ArtistImage> doInBackground(String... params) {
        try {           
            for (int i = 0; i <= 10; i++) {
                Collection<Artist> artistImage = Artist.getSimilar("Bon Iver", i, key);
                Iterator<Artist> itr = artistImage.iterator();
                while (itr.hasNext()) {
                    Artist temp = itr.next();
                    ArtistImage ai = new ArtistImage();
                    ai.image = ((ImageHolder) temp).getImageURL(ImageSize.MEGA);
                    ai.name = ((MusicEntry) temp).getName();
                    artistImages.add(ai);
                }
            }
        } catch (Exception e) {
            Log.i("images", e.getMessage());
        }

        return artistImages;
    }

    @Override
    protected void onPostExecute(List<ArtistImage> result) {
        artistAdapter.setArtistImages(result);
    }
}


public class ArtistAdapter extends ... {
    private List<ArtistImage> artistImages = new ArrayList<ArtistImage>();

    public void setArtistImages(List<ArtistImage> images) {
        this.artistImages = images;
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArtistImage image = artistImages.get(position);
        // render stuff here
    }
}