public class WorkoutFragment extends Fragment {
    RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.workout_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        setupRecyclerView(recyclerView);

        FloatingActionButton button = (FloatingActionButton) rootView.findViewById(R.id.fab2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // Get the layout inflater
                LayoutInflater inflater = getActivity().getLayoutInflater();

                View v = inflater.inflate(R.layout.dialog_fab, null);
                EditText e = view.findViewById(R.id.workoutTitle);
                builder.setView(v)
                        .setPositiveButton("Yes", ...) // You can set your normal listener here.
                        .setNegativeButton("Cancel", ...);
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();

                // !mportant - this should be called **after** dialog.show() or in a dialog OnShowListener
                // This is because the buttons arent truly attached till the dialog is shown;

                final Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

                e.addTExtWatcher(new TextWatcher() {
                    ...

                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        positiveButton.setEnabled(s.length() > 0);
                    }                    

                    ...
                });
            }
        });
        return rootView;
    }

    ...

}