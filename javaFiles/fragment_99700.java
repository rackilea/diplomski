mLeagueAdapter = new LeagueAdapter();

        final ListView listLeague = (ListView) findViewById(R.id.listView);

        listLeague.setAdapter(mLeagueAdapter);
        listLeague.setOnItemClickListener(new   AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {

                String leagueName = mLeagueAdapter.getItem(pos).getTitle();
                Intent myIntent = new Intent(getBaseContext(), BowlersActivity.class);
                myIntent.putExtra("value1", leagueName);
                startActivity(myIntent);
            }
        });