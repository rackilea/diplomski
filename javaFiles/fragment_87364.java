GPSTracker gp;
Context mContext;
private AsyncDataUpdate(Context context){
     this.mContext = context;
     this.gps = new GPSTracker(this.mContext);
}