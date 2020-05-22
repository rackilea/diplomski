public class BlankFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState) {
    View result=inflater.inflate(R.layout.fragment_blank, container, false);
    ViewPager pager=(ViewPager)result.findViewById(R.id.pager);

    pager.setAdapter(buildAdapter());

    return(result);
  }

  private PagerAdapter buildAdapter() {
    return(new SampleAdapter(getActivity(), getChildFragmentManager()));
  }
}