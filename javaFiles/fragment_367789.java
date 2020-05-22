protected void hideRelativeLayout(int current){
   for (int i = 0, len = relativeLayoutIdList.size(); i < len; i++){
       if(relativeLayoutIdList.get(i) == current){
            // visible current relativelayout
            (RelativeLayout)  findViewById(relativeLayoutIdList.get(i)).setVisibility(View.VISIBLE);
       }else{
            // hide all rest relativelayout
            (RelativeLayout)  findViewById(relativeLayoutIdList.get(i)).setVisibility(View.GONE);
       }
   }
}