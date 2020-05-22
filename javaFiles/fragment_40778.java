gridView.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View v,
                        int position, long id) {


                        Toast.makeText(
                            getApplicationContext(),
                            ((TextView) v.findViewById( R.id.tv_player_role ))
                                    .getText(), Toast.LENGTH_SHORT).show();

                }
            });