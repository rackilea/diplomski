ListView list = (ListView) findViewById(R.id.list);

            ListAdapter adapter =
                    new ExtendedAdaptor(
                            context,
                            oslist,
                            R.layout.list_v,
                            new String[]{TAG_PATH},
                            new int[]{R.id.vers});

            list.setAdapter(adapter);