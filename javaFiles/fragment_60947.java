public CustomExpandableListAdapter(Context context, List<String> listDataHeader,
                             HashMap<String, List<String>> listChildData) {
    super();
    this._context = context;
    this._listDataHeader = listDataHeader;
    this._listDataChild = listChildData;
}