public class MyFragment extends Fragment { 
   TextView myTextView;

   @Nullable
   @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     super.onCreateView(inflater, container, savedInstanceState);
     View view = View root = inflater.inflate(R.layout.my_frag_layout, null);
     myTextView = (TextView) view.findViewById(R.id.myTextView);
     //rest of your implementation of onCreateView
     return view;
   }

   //this will be called from activity
   public void updateTextView(String text) { 
       myTextView.setText(text);          
   }

}