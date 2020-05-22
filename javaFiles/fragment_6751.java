public class Work extends Fragment {

    public static final String TIME_PICKER = "TIME_PICKER";
    public static final String TIME_PICKER_2 = "TIME_PICKER_2";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_work, container, false);
        getActivity().setTitle("Work");

        Button timeButton = (Button) view.findViewById(R.id.btn1);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = TimePicker_Fragment.instance(TIME_PICKER);
                timePicker.show(getFragmentManager(), "Time Picker");
            }
        });

        Button timeButton2 = (Button) view.findViewById(R.id.btn2);
        timeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker2 =TimePicker_Fragment.instance(TIME_PICKER_2);
                timePicker2.show(getFragmentManager(), "Time Picker 2");
            }
        });

        return view;
    }
}