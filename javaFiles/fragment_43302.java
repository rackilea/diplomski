public class popFragment extends Fragment {

    private CardView cardView1;
    private CardView cardView2;

        public popFragment()
        {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view= inflater.inflate(R.layout.popfragment,container,false);
    cardView1 = view.findViewById(R.id.my_card_view_1);
    cardView2 = view.findViewById(R.id.my_card_view_2);

    cardView1.setOnClickListener(v->{
       //set on click functions here
    });

    cardView2.setOnClickListener(v->{
       //set on click functions here
    });

            return view;
        }
    }