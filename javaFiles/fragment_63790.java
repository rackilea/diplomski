public class ListViewFragment extends Fragment {

                DbHelper mydb;

                Button buttondeletedb;
                Button buttonexport;

                private EditText roomnr;

                @Override
                public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                    View view = inflater.inflate(R.layout.fragment_listview, container, false);

                    Context context = getContext();
                    mydb = new DbHelper(context);

                    buttondeletedb = (Button) view.findViewById(R.id.button_deletelist_list);
                    buttonexport = (Button) view.findViewById(R.id.button_export);

                    String dataList = mydb.getAllElements();                                                   
                    String [] dataListArray = dataList.split("\n");                                             

                    List<String> dataListFinal = new ArrayList<>(Arrays.asList(dataListArray));

                    ArrayAdapter<String> dataListAdapter = new ArrayAdapter<>(                                  
                            getActivity(),                                                                      
                            R.layout.list_item_datalist,                                                        
                            R.id.list_item_datalist_textview,                                                   
                            dataListFinal);                                                                     
            // Change made here. replace view instead of rootView and remove rootView
                    ListView dataListListView = (ListView) view.findViewById(R.id.datalist);
                    dataListListView.setAdapter(dataListAdapter);


                    buttondeletedb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("buttondeletelist", "clicked!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            mydb.deleteAll();
                        }
                    });
            // Replace rootView with view.
                    return view;
                }


            }