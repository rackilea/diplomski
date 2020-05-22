public class MyCoolFragment extends Fragment {

    // here "this" is in fact your Fragment,
    // so this.getActivity().getSharedPreferences() DOES exist

    .
    .
    .

    Button btn = (Button)findViewById(R.id.btnSave);
    btn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            // Perform action on click
            // "this" is NO LONGER your fragment, but the View.OnClickListener
            // to access the PARENT CONTEXT you prepend the CLASS NAME:

            // MyCoolFragment.this.getActivity().getSharedPreferences will work:


            SharedPreferences prefs = MyCoolFragment.this.getActivity().getSharedPreferences()
                    "com.example.app", Context.MODE_PRIVATE);

        }
    });