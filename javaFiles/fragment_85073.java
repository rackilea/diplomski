Song selectedSong;

        public void handleSelection(View view)
        {
            String resourceId = AppUtil.getResourceId(this, view);

            selectedSong = songCollection.searchById(resourceId);

            AppUtil.popMessage(this, "Streaming song: " + selectedSong.getTitle());

            sendDataToActivity(selectedSong);
        }

        public void sendDataToActivity (Song song)
        {
            Intent intent = new Intent (this, PlaySongActivity.class);

            intent.putExtra("id", song.getId());
            intent.putExtra("title", song.getTitle());
            intent.putExtra("artist", song.getartist());
            intent.putExtra("fileLink" ,song.getFileLink());
            intent.putExtra("coverArt", song.getCoverArt());

            startActivity(intent);
        }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)

        {
            View v = inflater.inflate(R.layout.fragment_trending, container, false);
            handleSelection(v);
            sendDataToActivity(selectedSong)

            return v;
        }