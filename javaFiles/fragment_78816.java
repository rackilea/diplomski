@Override
public void onItemClick(View view, int position) {
      if (position>1 && position % ITEM_PER_AD == 0) { 
            return; 
      }
      // rest of the code keep as it is.
}