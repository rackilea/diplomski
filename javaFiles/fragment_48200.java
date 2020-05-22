abstract public class DataPoller extends AsyncTask<Void, Void, Void> {
    ...
    Context mContext;
    ...
    DataPoller(Context context){
        super();
        this.mContext = context;
    }
    ...
}