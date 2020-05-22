public class MainListRVA extends RecyclerView.Adapter<ViewHolder> implements ConstantValues {

    FragmentManager oFm;

    private int viewPagerId = 1;

    static ArrayList<MainListItem> oListItems = new ArrayList<MainListItem>();

    MainListRVA(ArrayList<MainListItem> theArray, FragmentManager fm){
        oListItems = theArray;
        oFm = fm;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager_main_list_item_folder, parent, false);
        return new FolderVH(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Log.e("onBindViewHolder", "onBindViewHolder");

        FolderVH folderVH = (FolderVH) holder;
        MainListItem listItem = oListItems.get(position);
        folderVH.viewPager.setCurrentItem(0);

        if(folderVH.fragmentOne.title != null) {
            folderVH.fragmentOne.title.setText(listItem.oTitle);
        } else {
            folderVH.fragmentOne.bindExceptionally = true;
            folderVH.fragmentOne.currListItem = listItem;
        }
    }

    public class FolderVH extends RecyclerView.ViewHolder {

        FolderMainPageFragment fragmentOne, fragmentTwo;
        ViewPager viewPager;

        FolderVH(View v) {

            super(v);

            Log.e("FolderVH", "FolderVH");

            ArrayList<Fragment> fragments = new ArrayList<Fragment>();

            fragmentOne = FolderMainPageFragment.newInstance("one");
            fragmentTwo = FolderMainPageFragment.newInstance("two");

            fragments.add(fragmentOne);
            fragments.add(fragmentTwo);

            FolderVPAdapter folderVPAdapter = new FolderVPAdapter(oFm, fragments);

            viewPager = (ViewPager) v.findViewById(R.id.viewPager);
            viewPager.setId(viewPagerId++);
            viewPager.setAdapter(folderVPAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return oListItems.size();
    }

    void move(int fromPos, int toPos){ }

    void remove(int position){ }
}