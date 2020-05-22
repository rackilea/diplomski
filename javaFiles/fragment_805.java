public class YourFragment extends Fragment {
  ...
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    ...
    // This is an example, you can register the listener in any method

    // sample
    YourAdapter adapter = new YourAdapter(...);

    YourAdapter.AdapterListener listener = new YourAdapter.AdapterListener {
       @Override
       public void onItemClicked(int position) {

         // handle the item click here.
       }
    }
  }
}