private final Filter filter = new Filter() {
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

@Override
public Filter getFilter() {
    // CORRECT: Always use the same Filter instance.
    return this.filter;
}