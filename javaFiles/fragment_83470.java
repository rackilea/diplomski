@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view;
    if (convertView == null){
        view = inflater.inflate(R.layout.list_row, null);
    } else {
        view = convertView;
    }

    TextView title = (TextView) view.findViewById(R.id.libraryName);
    TextView author = (TextView) view.findViewById(R.id.libraryVersion);
    TextView pages = (TextView) view.findViewById(R.id.libraryCopyright);

    HashMap<String, String> mBook = new HashMap<>();
    mBook = books.get(position);

    title.setText(mBook.get("title"));
    author.setText(mBook.get("author"));
    pages.setText(mBook.get("pages"));

    return view;
}