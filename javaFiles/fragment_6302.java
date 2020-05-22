public abstract class MyAdapter extends BaseAdapter implements JniSource.Observer {
    private int observer_count = 0;

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        if(observer_count == 0) {
            JniSource.registerObserver(this);
        }

        observer_count++;
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
        //FIXME: what if unregisterDataSetObserver got called for a non-registered observer?
        observer_count--;
        if(observer_count == 0) {
            JniSource.unregisterObserver(this);
        }
    }

    public void onJniSourceDataChanged() {
        notifyDataSetChanged();
    }
};