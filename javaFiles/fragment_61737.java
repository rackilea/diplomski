@Override
public Filter getFilter() {
    if (mFilter == null) {
        mFilter = new JobFilter();
    }
    return mFilter;
}