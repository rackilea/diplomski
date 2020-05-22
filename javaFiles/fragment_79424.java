@Override
protected FilterResults performFiltering(CharSequence charSequence) {
    // Here is Background Thread, never alter adapter list in this method
    String charString = charSequence.toString();
    List<RegisterGuestList.Guest> filteredList = new ArrayList<>();

    if (charString.isEmpty()) {
        filteredList.addAll(mSearchGuestListResponseList);
    } else {
        ... // fill filteredList as you did previously
    }

    FilterResults filterResults = new FilterResults();
    filterResults.values = filteredList;
    filterResults.count = filteredList.size(); // count is optional
    return filterResults;
}

@Override
protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
    // Here is Main Thread, safe to update list and notify adapter
    mSearchGuestListResponseListFiltered = (ArrayList<RegisterGuestList.Guest>) filterResults.values;
    searchText = charSequence.toString();
    notifyDataSetChanged();
}