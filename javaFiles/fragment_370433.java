public class aboutSLFragment extends Fragment{

ViewPager viewPager;
LinearLayout sliderDotspanel;
private int dotscount;
private ImageView[] dots;

public aboutSLFragment() {
  // Required empty public constructor
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

View rootView = inflater.inflate(R.layout.fragment_about_sl, container, false);
viewPager = (ViewPager) rootView .findViewById(R.id.viewPager);

sliderDotspanel = (LinearLayout)rootView.findViewById(R.id.SliderDots);

ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());

viewPager.setAdapter(viewPagerAdapter);

dotscount = viewPagerAdapter.getCount();
dots = new ImageView[dotscount];

for(int i = 0; i < dotscount; i++){

    dots[i] = new ImageView(getContext());
    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    params.setMargins(8, 0, 8, 0);

    sliderDotspanel.addView(dots[i], params);

}

dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for(int i = 0; i< dotscount; i++){
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
        }

        dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});

 // Inflate the layout for this fragment
 return rootView;
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
  super.onViewCreated(view, savedInstanceState);
  //you can set the title for your toolbar here for different fragments different titles
  getActivity().setTitle("About Sri Lanka");
 }

}