private void customToast(String Content) {

        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        View customToastroot = inflater.inflate(R.layout. activity_toast, null);
        Toast toast = Toast.makeText(context, Content, Toast.LENGTH_LONG);
        toast.setView(customToastroot);
        TextView text =  customToastroot.findViewById(R.id.toast_text);
        /*Here you can do anything with above textview like text.setTextColor(Color.parseColor("#000000"));*/
        text.setText(Content);
        toast.show();
    }