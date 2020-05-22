HashMap<Integer, View> emailMap = new HashMap<>();
int emailIndex = 0;

protected void delEmailEditView(){
    if(emailMap.size() <= 0) return;
    View v = emailMap.remove(emailIndex);
    if(v == null) return;
    ((ViewGroup)v.getParent()).removeView(v);
    emailIndex--;

    // Get rid of any resources allocated to the view
    v = null;

    // If you just want to make it GONE
    //View view = emailMap.get(emailIndex);
    //view.setVisibility(View.GONE);
}

protected void createEmailEditView(){
    Context context=getApplicationContext();
    EditText designation1 = new EditText(context);
    designation1.setSingleLine(true);
    designation1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    designation1.setPadding(14,30,14,30);
    designation1.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.editview));
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    params.addRule(RelativeLayout.BELOW, R.id.e1+emails);
    RelativeLayout RL=findViewById(R.id.parentLayout);
    RL.addView(designation1, params);

    emailMap.put(emailIndex, designation1);
    emailIndex++;
    designation1.setHint("email " + emailIndex);
}