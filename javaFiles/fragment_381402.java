public class WorkoutFragment extends Fragment {
    RecyclerView recyclerView;

    public View onCreateView(...) {
        ...
    }

    ...

    private void onAddWorkout(String workoutTitle) {
        SimpleStringRecyclerViewAdapter adapter = (SimpleStringRecyclerViewAdapter) recyclerView.getAdapter;

        // You should probably use an ArrayList so that addition and removal of items will not require creating another object
        int length = adapter.mValues.length;
        adapter.mValues = Arrays.copyOfRange(adapter.mValues, 0, length + 1);
        adapter.mValues[length] = workoutTitle;
        adapter.notifyItemInserted(length);
    }

    ...


}