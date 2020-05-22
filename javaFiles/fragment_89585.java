@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View drawer = inflater.inflate(R.layout.fragment_one, container, false);

            feedsList = new ArrayList<FeedItem>();
            mRecyclerView = (RecyclerView) drawer.findViewById(R.id.recycler_view);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            progressBar = (ProgressBar) drawer.findViewById(R.id.progress_bar);
            String url = "http://krishscs.esy.es/RecycleViewExample/RecycleViewExample.php";
            mSearchView = (SearchView) drawer.findViewById(R.id.search_view);
            setupSearchView();
            new DownloadTask().execute(url);
            adapter = new MyRecyclerViewAdapter(getActivity(),feedsList);
            Toast.makeText(getActivity(), "HELLO", Toast.LENGTH_SHORT).show();
            mRecyclerView.setAdapter(adapter);


            // Inflate the layout for this fragment
            return drawer;
        }