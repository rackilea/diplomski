@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    date = (TextView) view.findViewById(R.id.textDate);
    date.setText(DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime()));
}