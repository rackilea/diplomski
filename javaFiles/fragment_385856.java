@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_offers_made, container, false);
    ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
    viewPager.setAdapter(new OffersFragmentPagerAdapter(getFragmentManager(), getActivity()));

    SlidingTabLayout slidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.sliding_tabs);
    slidingTabLayout.setDistributeEvenly(true);
    slidingTabLayout.setViewPager(viewPager);

    return view;
}