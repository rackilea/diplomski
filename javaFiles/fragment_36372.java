@Override
public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

    if (parent.getLayoutManager() instanceof LinearLayoutManager){
        margin = 2;
    }else if (parent.getLayoutManager() instanceof StaggeredGridLayoutManager){
        margin = 1;
    }else{
        margin = 0;
    }

    //Do magic
}