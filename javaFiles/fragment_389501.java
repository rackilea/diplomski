interface RadioClickListener{
    void radioClicked(int position, int rate);
}
...
RadioClickListener radioClickListener;
...
public RateAdapter(Context context, ArrayList<String> arrayList) {
    super(context, 0, arrayList);
    this.context = context;
    radioClicked = (RadioClickListener) context;
}