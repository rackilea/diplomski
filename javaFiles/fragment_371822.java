public class AutoCompleteTextAdapter extends ArrayAdapter<String> implements Filterable {
    ArrayList<String> mSuggestions = null;
    ....
    @Override
public Filter getFilter(){
    Filter myFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if ( charSequence != null ){


                // Now assign the values and count to the FilterResults object
                if ( mSuggestions != null ){
                    filterResults.values = mSuggestions.toArray();
                    filterResults.count = mSuggestions.size();
                }

                Log.e(TAG, "performFiltering: finish;");

            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            Log.d(TAG, "publishResults: " + charSequence);
            if ( filterResults != null && filterResults.count > 0 )
                notifyDataSetChanged();
            else
                notifyDataSetInvalidated();




        }
    };
    return myFilter;
}

public void updateList ( ArrayList<String> str ){


    mSuggestions = str;


    notifyDataSetChanged();
}