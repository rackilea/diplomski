public SettingsRecyclerAdapter (Context context){
            mContext = context;
            // .. Attach the interface
            try{
                onAdapterResult = (OnAdapterResult) context;
            }catch(ClassCastException ex){

                Log.e("MyAdapter","error"+ ex,);
            }
        }