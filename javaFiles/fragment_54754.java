private List<YourModel> modelList;
 private List<YourModel> modelListCopy;
 private ItemFilter mFilter = new ItemFilter();


 public YourAdapter(List<YourModel> modelList) {
    this.modelList= modelList;
    this.modelListCopy= new ArrayList<>();
    modelListCopy.addAll(modelList);
}
private class ItemFilter extends Filter {

    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length() > 0) {
            List<YourModel> filterList = new ArrayList<YourModel>();

            for (int i = 0; i < modelListCopy.size(); i++) {
                if ((modelListCopy.get(i).getName().toUpperCase())
                        .contains(constraint.toString().toUpperCase())) {
                    YourModel builddata = new YourModel(modelListCopy.get(i).getImages(), modelListCopy.get(i).getName());
                    filterList.add(builddata);
                }
            }
            results.count = filterList.size();
            results.values = filterList;

        } else {
            results.count = modelListCopy.size();
            results.values = modelListCopy;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint,
                                  FilterResults results) {
        modelList= (ArrayList<YourModel>) results.values;
        notifyDataSetChanged();
    }