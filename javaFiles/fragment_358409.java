EditText editText;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.dataedit, container, false);
    Button btnResetForm = (Button) v.findViewById(R.id.btnResetFormxml);
    btnResetForm.setOnClickListener(this);
    editText = (EditText) v.findViewById(R.id.edArea);
    return v;
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btnResetFormxml:
            resetForm();
            break;
    }
}

public void resetForm() {             
    editText.setText(""); 
}