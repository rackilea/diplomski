public MyFragment extends Fragment {
    public interface Callback {
        public void onRadioButtonClicked(View radioButton);
    }

    private Callback callback;

    @Override
    public void onAttach(Activity ac) {
        super.onAttached(ac);
        callback = (Callback)ac;
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

    ....
    ....
       radioButton.setOnClickListener(new OnClickListener() {
           public void onClick(View view) {
               if (callback != null) {
                   callback.onRadioButtonClicked(view);
               }
           }
       });
}