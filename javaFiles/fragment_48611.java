public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            factTitle = (TextView) rootView.findViewById(R.id.fact_label);
            factDesc = (TextView) rootView.findViewById(R.id.fact_description);
            factImg = (ImageView) rootView.findViewById(R.id.imageView);
            loader = (ProgressBar) rootView.findViewById(R.id.progressBar);
            fetchData process = new fetchData(getActivity(),factTitle,factDesc,factImg,loader);
            process.execute();
            return rootView;
        }
    }