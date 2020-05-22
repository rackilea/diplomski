public void updateList(ArrayList<StatisticsModel> itemList){
        list.clear();
//        this.list = itemList;
//        list.addAll(itemList);
//        notifyItemInserted(list.size());
//        notifyDataSetChanged();
        this.list.addAll(itemList);
//        notifyItemInserted(list.size());
        notifyDataSetChanged();
    }