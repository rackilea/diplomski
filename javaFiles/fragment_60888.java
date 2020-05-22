@Override
public Filter getFilter() {
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            // Filter data ...
            // ...

            FilterResults filterResults = new FilterResults();
            filterResults.values = dienstListFiltered;
            filterResults.count = dienstListFiltered.size();
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dienstListFiltered = (ArrayList<Dienst>) filterResults.values;
            notifyDataSetChanged();
        }
    };
}