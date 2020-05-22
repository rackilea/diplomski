for (Iterator<CustomObject> iterator = mAdapter.iterator(); iterator.hasNext();) {
     CustomObject itemsData = iterator.next();
     if (itemsData.getItemsData().get(i).getPriceTier() != 1) { //if statement throws error
            // Remove the current element from the iterator and the list.

            iterator.remove();
        }
        i++;
      }
    CustomObject itemsData = iterator.next();