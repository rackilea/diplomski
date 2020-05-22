public class SearchActivity extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = null;
        if(convertView == null){
            convertView= getLayoutInflater(savedInstanceState).inflate(R.layout.activity_search, container, false);
        }
        return convertView;
    }
}