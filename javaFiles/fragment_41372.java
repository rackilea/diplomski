@Override
 public int getItemViewType(int position) {

    if (position>1 && (position+1) % 4 == 0) {
            return AD_TYPE;
     }
     return CONTENT_TYPE;
 }