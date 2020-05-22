// make this not final local variable, but a field in activity so you can remember filtered items
     final List<DataAdapter> filteredModelList = filter(DataAdapterClassList, newText);
     if (filteredModelList.size() > 0) {
         recyclerViewadapter.setFilter(filteredModelList);
         return true;
     } else {