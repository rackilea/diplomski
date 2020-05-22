public class armarFragment extends Fragment implements View.OnClickListener{
    ...
    private armarFragmentListener mListener;

    public interface armarFragmentListener {
        void onEnviar ();
    }

@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        mListener = (armarFragmentListener) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement armarFragmentListener ");
    }
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btnEnviarALaCocina:
            //Do what you want.
            mListener.onEnviar(/*Change interface to pass arguments if you want*/);
        break;
    }
}