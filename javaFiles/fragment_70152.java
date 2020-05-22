public class ProEdiCon extends DialogFragment {

private CallBackListener callBackListener;
@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
    if (getActivity() instanceof CallBackListener)
        callBackListener = (CallBackListener) getActivity();
}
@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle bun) {
    View pro_vie = inflater.inflate(R.layout.pro_edi_dat, container, false);

    TextView tv = pro_vie.findViewById(R.id.tv);
    tv.setText("I am the Dialog Fragment who is gonna be dismissed soon");

    Button btn = pro_vie.findViewById(R.id.btn);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(callBackListener != null)
                callBackListener.onDismiss();
            dismiss();
        }
    }

    return pro_vie;
}
}