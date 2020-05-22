@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.songs_list, container, false);
    lv =(ListView) view.findViewById(R.id.lvPlaylist);

    ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());
    for(int i=0; i<mySongs.size(); i++){
        toast(mySongs.get(i).getName().toString());
    }

    return view
}