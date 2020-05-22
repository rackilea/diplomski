@Override
public void onListItemClick(ListView lv, View v, int pos, long id) {
     ma.setSelecteIndex(pos , v);
     ((Menu_Adapter)lv.getAdapter()).notifyDataSetChanged();
     Fragment newContent;
     if(pos==0){
        newContent = new HomeFragment();
     }else if(pos==1){
        newContent = StoresFragment.NewInstance(pos);
     }else{
        newContent = DinningFragment.NewInstance(pos);
     }
    if (newContent != null)
        switchFragment(newContent);
}

// the meat of switching the above fragment
private void switchFragment(Fragment fragment) {
    if (getActivity() == null)
        return;

    if (getActivity() instanceof CustomAnimation) {
        CustomAnimation ra = (CustomAnimation) getActivity();
        ra.switchContent(fragment);
    }
}