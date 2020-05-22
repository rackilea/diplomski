@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.cManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
    this.mTextView = (TextView)this.findViewById(R.id.mProgressText);
}