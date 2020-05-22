@Override
public Filter getFilter() {
    if (filter == null) {
        filter = new ArrayFilter();
    }
    return filter;
}

private class ArrayFilter extends Filter{
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if(constraint != null && constraint.length()> 0) {
            ArrayList<Categoria> values = new ArrayList<Categoria>(original);
            filtered = new ArrayList<Categoria>();
            int length = values.size();
            for (int i = 0; i<length; i++) {
                Locale locale = Locale.getDefault();
                Categoria item = values.get(i);
                String data = item.getTitulo();
                if (data.toLowerCase(locale).contains(constraint.toString())) {
                    filtered.add(item);
                }
            }
            filterResults.values = filtered;
            filterResults.count = filtered.size();
        }else{
            synchronized(this) {
                filterResults.count = original.size();
                filterResults.values = original;
            }
        }
        return filterResults;
    }
    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        data = (List<Categoria>) results.values;
        notifyDataSetChanged();
        clear();
        addAll(data);
        notifyDataSetInvalidated();
    }
}