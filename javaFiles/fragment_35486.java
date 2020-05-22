@Override
public void onListItemClick(ListView l, View v, int position, final long id) {
        if (selectedItems.size() < 2){
            selectedItems.add(item.text);
            if (selectedItems.size() == 1) {
                MyAppClass.getInstance().saveSharedSetting(getActivity(), "Titles", selectedItems.get(0));
            }else {

 MyAppClass.getInstance().saveSharedSetting(getActivity(), "Titles", TextUtils.join(", ", selectedItems));
            }

            Log.e("onListItemClick()","Read Titles..."+MyAppClass.getInstance().readSharedSetting(getActivity(), "Titles","TitlesRead"));
//
        }else {

                for (int i =0; i < selectedItems.size(); i++ ){
                    if (selectedItems.get(i) == item.text){
                        selectedItems.remove(i);
                    }
            }

            //                sparseBooleanArray.put(position, false);//.get(position) = false;
            getListView().setItemChecked(position, false);
            Toast.makeText(getActivity(), "Max 2 Items Reached ! - ", Toast.LENGTH_SHORT).show();
        }