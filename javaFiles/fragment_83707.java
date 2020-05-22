public class HomeFragment extends Fragment {
...
RecyclerView mRecyclerView;
...

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fishPriceList);
}
}