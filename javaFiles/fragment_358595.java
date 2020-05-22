@Override
protected void onCreate(Bundle bundle) { 
    super.onCreate(bundle);
    mCardScroller = new CardScrollView(this);
    mCardScroller.setAdapter(new danceAdapter(dataset));
    mCardScroller.activate();
    setContentView(mCardScroller);
 }


 public class danceAdapter extends CardScrollAdapter { 
    private ArrayList<Object> mDataSet;
    public danceAdapter(ArrayList<Object> dataset){ 
        this.mDataSet = dataset;
    }

    @Override
    public int getCount() { 
        return mDataSet.size(); 
    }

    @Override
    public Object getItem(int i){ 
        return mDataSet.get(i); 
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { 
        Object dataset = getItem(i);

        return new CardBuilder(context, CardBuilder.Layout.TEXT)
            .setText(dataset.getInfo())
            .getView();
    }

    @Override
    public int getPosition(Object o) { 
        return this.mDataSet.indexOf(o); 
    }
}