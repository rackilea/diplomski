private ArrayList<CustomObj> mFilteredList, mUnfilteredList;
private Filter mFilter;

@Override
public Filter getFilter() {
    if(mFilter == null) {
        mFilter = new Filter() {

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredList = (ArrayList<CustomObj>)results.values;
            notifyDataSetChanged();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            ArrayList<CustomObj> newList = new ArrayList<CustomObj>();              
            for (CustomObj obj : mUnfilteredList) {
                // Compare the custom object and add to list if match
                if(customCompare(obj, constraint)
                    newList.add(obj);
            }
            results.values = newList;
            results.count = newList.size();
            return results;
        }
        };
    }
    return mFilter;
}