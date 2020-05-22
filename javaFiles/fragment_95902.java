iv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent go = new Intent(getActivity(),next_activity.class);
        startActivity(go);
    }
});