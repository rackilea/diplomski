relaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int
    position, long id) {


            HashMap<String, String> o = (HashMap<String, String>)
    relaylist.getItemAtPosition(position);



            Log.e("ip: ", "> " +  o.get("ip"));
            Log.e("port: ", "> " +  o.get("port"));
            Log.e("uname: ", "> " +  o.get("uname"));
            Log.e("password: ", "> " +  o.get("password"));


            ControlFragment fragment = new ControlFragment();

            FragmentTransaction transaction =
    getFragmentManager().beginTransaction();


            Log.e("ip: ", "> " +  o.get("ip"));
            Log.e("port: ", "> " +  o.get("port"));
            Log.e("uname: ", "> " +  o.get("uname"));
            Log.e("password: ", "> " +  o.get("password"));
            transaction.replace(R.id.mainFrame, fragment );
            Bundle bundle = new Bundle();
            bundle.putString("ip", o.get("ip"));
            bundle.putString("port", o.get("port"));
            bundle.putString("uname", o.get("uname"));
            bundle.putString("password", o.get("password"));
            fragment.setArguments(bundle);
            transaction.commit();
        }
    });