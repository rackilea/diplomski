private ArrayList<Integer> layoutsIds = new ArrayList<>();

public void loadList(){
    resetViews();
    (...)
    (...)
    layoutId = generateViewId();
    linearVertical.setId(layoutId);
    layoutsIds.add(layoutId);
    (...)
    (...)
}

public void resetViews(){
    for(int a=0; a<layoutIds.size(); a++){
        LinearLayout toRemove = (LinearLayout)findViewById(layoutIds.get(a));
        toRemove.setVisibility(View.GONE);
    }
}