private ItemFilter mFilter;

private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<Persons> filterList = new ArrayList<Persons>();
                for (int i = 0; i < filteredItems.size(); i++) {

                    Persons person = filteredItems.get(i);
                    String name = person.getName().toUpperCase();
                    String city = person.getCity().toUpperCase();
                    if (name.contains(constraint.toString().toUpperCase()) || city.contains(constraint.toString().toUpperCase())) {

                        filterList.add(person);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = filteredItems.size();
                results.values = filteredItems;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                FilterResults results) {
            arrayList  = (ArrayList<Persons>) results.values;
            notifyDataSetChanged();
        }

    }

 public Filter getFilter() {
     if (itemFilter == null) {
         itemFilter = new ItemFilter();
     }
     return itemFilter;
 }

 @Override
 public long getItemId(int position) {
     return arrayList.indexOf(getItem(position));
 }