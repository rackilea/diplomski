public class PostDetail extends Fragment {
   TextView mTitle;
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(R.layout.YOUR_LAYOUT_VIEW,   null);
        mTitle= (TextView ) _view.findViewById(R.id.YOUR_TEXTVIEW_ID);
       return view;
     }

}