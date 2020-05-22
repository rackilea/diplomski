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
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                if (!TextUtils.isEmpty(e.getText().toString())) {
                                    // This block is responsible for checking if edittext is empty and carrying out the action
                                    onAddWorkout(e.getText().toString());
                                }
                            }
                        })
                        .setNegativeButton("Cancel", ...);
                // Create the AlertDialog object and return it
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        return rootView;
    }

    ...

}