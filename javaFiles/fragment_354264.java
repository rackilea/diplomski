public class ScreenSlidePageFragment extends Fragment {
    private String text;    
    public void setText(String text){

     this.text=text;
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_viewer, container, false);
        ((TextView)rootView.findViewById(textViewId)).setText(Text);
        return rootView;
    }
}