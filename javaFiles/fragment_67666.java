listview=(ListView)rootView.findViewById(android.R.id.list);

listview.setOnItemClickListener(new OnItemClickListener() {   
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
       Intent intent=new Intent(getActivity().getApplicationContext(),ProfileEdit.class);
       intent.putExtra("position", arg2);
       startActivity(intent);
    }
});