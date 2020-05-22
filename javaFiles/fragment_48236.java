@Override
 public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof ObjectSender) {
        obj = (ObjectSender) context; //Reference to activity
    } else {
        throw new RuntimeException(context.toString()
                    + " must implement ObjectSender");
    }
}

@Override
public void onDetach() {
    super.onDetach();
    obj = null;
}

@Override
public void onResume(){
   super.onResume();
   text= (EditText) getActivity().findViewById(R.id.editText2);
   text2=(EditText) getActivity().findViewById(R.id.editText3);
   text3=(EditText) getActivity().findViewById(R.id.editText4);
   bottone1= (Button) getActivity().findViewById(R.id.button);

   bottone1.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           segnalazione.setNome(text2.getText().toString());
           segnalazione.setCognome(text3.getText().toString());
           obj.sender(segnalazione);
       }
   });
}