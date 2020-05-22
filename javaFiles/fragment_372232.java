public class RequisitionsFragment extends Fragment {

public static TabLayout tabLayout;
public static ViewPager viewPager;
public static int int_items = 3 ;
String username;

public RequisitionsFragment() {
    // Required empty public constructor
}

public static RequisitionsFragment newInstance(String username) {
    RequisitionsFragment fragment = new RequisitionsFragment();
    Bundle args = new Bundle();
    args.putString("USERNAME", username);
    fragment.setArguments(args);
    return fragment;
}

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View x =  inflater.inflate(R.layout.tab_layout,null);
    tabLayout = (TabLayout) x.findViewById(R.id.tabs);
    viewPager = (ViewPager) x.findViewById(R.id.viewpager);
    viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    tabLayout.post(new Runnable() {
        @Override
        public void run() {
            tabLayout.setupWithViewPager(viewPager);
        }
    });
    username = getArguments().getString("USERNAME");
    return x;
}


class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0 : return PendingFragment.newInstance(username);
            case 1 : return new ApprovedFragment();
            case 2 : return new CompletedFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return int_items;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "Pending";
            case 1 :
                return "Approved";
            case 2 :
                return "Completed";
        }
        return null;
    }
}
}