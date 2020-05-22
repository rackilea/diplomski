userList = (ListView) context.findViewById(R.id.iliked_list);

    adapter = new MyAdapter(context.getContext(), result);
    userList.setAdapter(adapter);
    //System.out.println("List Content: "+result.get(0));
    userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Profile fr = new Profile();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Bundle args = new Bundle();
            args.putString("username", result.get(position).getUsername());
            fr.setArguments(args);
            ft.replace(R.id.content_frame, fr);
            ft.commit();

        }
    });