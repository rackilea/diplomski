public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private ArrayList<Note> notes = new ArrayList<Note>();
    private ImageView image;
    private int imageCross;
    TextView ruleNotesSet;
    final SharedPreferences FeedPref= PreferenceManager.getDefaultSharedPreferences(getContext());
    final SharedPreferences.Editor fd = FeedPref.edit();

    public CustomListAdapter(Activity context, ArrayList<String> notes, int imageCross) {
        super(context, R.layout.item,notes);
        this.context=context;
        this.notes = notes;
        this.imageCross = imageCross;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        Note note = notes.get(position);

        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.item, null, false);
        ruleNotesSet = (TextView) rowView.findViewById(R.id.textView1);
        image = (ImageView) rowView.findViewById(R.id.icon);

        Glide.with(getContext())
                .load(imageCross)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(image);


        image.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Note n = (Note) v.getTag();
                notes.remove(n);
                fd.remove(n.getKeyAsString());
                fd.apply();
                fd.commit();
                notifyDataSetChanged();
            }
        });

        ruleNotesSet.setText(note.getNote());

        image.setTag(note);

        return rowView;
    }

    public void addNote(String data) {
        Note note = new Note(System.currentTimeMillis(), data);
        fd.putString(note.getKeyAsString(), note.getNote());
        fd.commit();
        notes.add(note);
        notifyDataSetChanged();
    }
}