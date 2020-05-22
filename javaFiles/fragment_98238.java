@Override
public SongListFragment getItem(int position) {
     SongListFragment slf = new SongListFragment();
     slf.setAudioList(getAudioList(tabTitles[position]));
     slf.setItemOnClickListener(new SongListFragment.SongListItemOnClickListener() {
        @Override
        public void onClick(Audio audio) {
            itemListener.onClick(audio);
        }
     });
     return slf;
}