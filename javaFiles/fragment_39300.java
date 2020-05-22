public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> implements Filterable {


    private Context iContext;

    private List<Items> itemsList = new ArrayList<>();
    private List<Items> itemsListFilter = new ArrayList<>();

    public ItemAdapter(List<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.itemsListFilter = itemsList;
        iContext = context;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemsList = (List<Items>) results.values;
                notifyDataSetChanged();
            }
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Items> filteredList = new ArrayList<>();
                String searchText = constraint.toString().toLowerCase();
                String[] split = searchText.split(",");
                ArrayList<String> searchGenres = new ArrayList<>(split.length);
                for (String aSplit : split) {
                    // remove spaces
                    String trim = aSplit.trim();
                    // skip empty entries
                    if (trim.length() > 0)
                        searchGenres.add(trim);
                }

                for (Items dataNames : itemsListFilter) {
                    // filter by title
                    if (dataNames.getItem().toLowerCase().trim().contains(searchText)) {
                        filteredList.add(dataNames);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;
                return results;
            }

        };
        return filter;
    }



}