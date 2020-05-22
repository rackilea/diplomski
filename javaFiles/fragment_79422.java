@Override
public Filter getFilter() {
    // WRONG: Return new instance of Filter every time getFilter() is called
    return new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            // Perform filtering...
            return anything;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            // Update and Notify adapter...
        }
    };
}