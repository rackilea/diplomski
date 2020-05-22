Adaptor adapter = new Adaptor(languges)
rl.setAdapter(adapter);

adapter.setClickItemListener(new ClickableAdapter.ClickItemListener() {
            @Override
            public void onClickItem(View v, int position) {
                if(position==0)
            {
                 Intent intent=new Intent(PakistaniActivity.this,Revival_Activity.class);
                 startActivity(intent);
            }

            }
        });