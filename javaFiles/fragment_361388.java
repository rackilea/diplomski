public class Rewards {
    private Firebase mListref;
    private final Context mcontext;
    Button mstreaming,mcustom,mlauncher,mmovies;

    public Rewards(Context context, Firebase ref, View rootView){
        this.mListref = ref;
        this.mcontext = context;

        if (rootView != null) {
             this.mstreaming = (Button) rootView.findViewById(R.id.streaming);
            this.mcustom = (Button) rootView.findViewById(R.id.custom);
            this.mlauncher = (Button) rootView.findViewById(R.id.launcher);
            this.mmovies = (Button) rootView.findViewById(R.id.movies);
        } 
    }
}