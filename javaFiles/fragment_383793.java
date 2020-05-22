private ListView portfolioList;
private PortfolioListAdapter adapter;

@Override
public void onAttach(Context context) {
    super.onAttach(activity);
    ( (Activity) context).setTitle("Portfolio");

    adapter = new PortfolioListAdapter(context, stockTicker, stockPrice, shares, percentChange);
    portfolioList.setAdapter(adapter);
}

@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.portfolio_layout, container, false);
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    portfolioList = (ListView) view.findViewById(R.id.portfolioListView);
}