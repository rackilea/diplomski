@Override
public Filter getFilter() {
    if(valueFilter == null){
        valueFilter = new ValueFilter();
    }

    return valueFilter;
}

private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            FilterResults results = new FilterResults();

            if(charSequence == null || charSequence.length() > 0){

                ArrayList<Product> filter = new ArrayList<Product>();

                for(int i = 0; i < mFilterList.size(); i++){
                    if((mFilterList.get(i).getName().toUpperCase())
                        .contains(charSequence.toString().toUpperCase())){
                        Product p = new Product();
                        p.setName(mFilterList.get(i).getName());

                        filter.add(p);
                    }
                }

                results.values = filter;
                results.count = filter.size();
            }else{
                results.values = mFilterList;
                results.count = mFilterList.size();
            }


            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence,
                FilterResults results) {
            pItems = (List<Product>) results.values;
            notifyDataSetChanged();
        }

    };