private ExpandableListAdapter listAdapter;
private ExpandableListView expListView;
private List<String> listDataHeader;
private HashMap<String, List<String>> listDataChild1, listDataChild2;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View cpf = inflater.inflate(R.layout.checklist_bstart, container, false);
    expListView = cpf.findViewById(R.id.lv_bstart);
    prepareListData();
    listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild1, listDataChild2);
    expListView.setAdapter(listAdapter);
    return cpf;
}

private void prepareListData() {
    listDataHeader = new ArrayList<>();
    listDataChild1 = new HashMap<>();
    listDataHeader.add(getResources().getString(R.string.bstart_ver));
    listDataHeader.add(getResources().getString(R.string.bstart_op));
    List<String> Header1 = new ArrayList<>();
    Header1.add(getResources().getString(R.string.bstart_string1));
    Header1.add(getResources().getString(R.string.bstart_string2));
    Header1.add(getResources().getString(R.string.bstart_string3));
    List<String> Header12 = new ArrayList<>();
    Header12.add(getResources().getString(R.string.bstart_string4));
    Header12.add(getResources().getString(R.string.bstart_string5));
    Header12.add(getResources().getString(R.string.bstart_string6));

    List<String> Header2 = new ArrayList<>();
    Header2.add(getResources().getString(R.string.bstart_string4));
    Header2.add(getResources().getString(R.string.bstart_string5));
    Header2.add(getResources().getString(R.string.bstart_string6));
    Header2.add(getResources().getString(R.string.bstart_string7));
    Header2.add(getResources().getString(R.string.bstart_string8));
    List<String> Header22 = new ArrayList<>();
    Header22.add(getResources().getString(R.string.bstart_string1));
    Header22.add(getResources().getString(R.string.bstart_string2));
    Header22.add(getResources().getString(R.string.bstart_string3));
    Header22.add(getResources().getString(R.string.bstart_string7));
    Header22.add(getResources().getString(R.string.bstart_string8));

    listDataChild1.put(listDataHeader.get(0), Header1);
    listDataChild1.put(listDataHeader.get(1), Header2);
    listDataChild2.put(listDataHeader.get(0), Header1);
    listDataChild2.put(listDataHeader.get(1), Header2);
}