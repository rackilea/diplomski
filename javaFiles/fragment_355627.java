@Override
        public boolean onQueryTextChange(String newText) {
            boolean success = false;
            ArrayList<ItemClass> tempList = new ArrayList<>();
            for(ItemClass temp : nomenclatureList){
                if(temp.getNomenclatureName().toLowerCase().contains(newText.toLowerCase())){
                    tempList.add(temp);
                }
            }
             ArrayAdapter<String> adapter = new ArrayAdapter<>(ItemListGKI.this, android.R.layout.simple_list_item_1, tempList);
             listView.setAdapter(adapter);
             tempList.size();
             if(tempList.size() > 0){
                success = true;
            }
        return success;
    }