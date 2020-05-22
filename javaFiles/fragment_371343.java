public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_workout_list, container, false);
    workoutList = (ListView) view.findViewById(R.id.workoutListView); // assuming that your listView's id is "@+id/workoutListView"
    return view;
}