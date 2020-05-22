@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_page_layout, container, false);

    // Get references to layout elements
    pageTextView = (TextView) view.findViewById(R.id.article_paragraph_title);
    return view;
}