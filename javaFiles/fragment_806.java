public class YourFragment extends Fragment {
  private FragmentListener mListener;

  public interface FragmentListener {
    onRecyclerViewItemClicked(int position);
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

    // This makes sure that the container activity has implemented
    // the callback interface. If not, it throws an exception
    try {
        mCallback = (FragmentListener) context;
    } catch (ClassCastException e) {
        throw new ClassCastException(context.toString()
                + " must implement FragmentListener");
    }
  }

}