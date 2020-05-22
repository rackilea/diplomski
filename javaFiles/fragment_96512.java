list.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        mPosition = position;
        alertNot.show();
    }
});