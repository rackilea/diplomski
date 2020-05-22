public void filterList(String searchText)
{
    ArrayList<C_ChatListItem> temp = new ArrayList<>();
    adapteritems = backupItems; // copy your Get response in backupItems for new searches in constructor
                                // then in every new search retrieve adapterIems
    if(searchText != null && searchText.length() > 0)
    {
        for (int i = 0 ; i < adapteritems.size() ; i++)
        {
            if(adapteritems.get(i).users_entry.contains(searchText))
                temp.add(item);
        }
        adapteritems = temp;
    }
    notifyDataSetChanged();
}