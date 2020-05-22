public class ListViewFragment extends Fragment {

private String listItems[] = {"vfvd","vdvvfv","vvddv","vfddvvd"}; //static data
ListView userList;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_list_view, container, false);



    userList = view.findViewById(R.id.userList);

    ArrayAdapter arrayAdapter = new 
    ArrayAdapter(getActivity(),R.layout.user_list_items,listItems);
    userList.setAdapter(arrayAdapter);

    return view;

}