public void fill(final ArrayAdapter<StructMoshtariItem> adapter, final StructMoshtariItem item, final int position) {
        name.setText(item.id);
        tel.setText(item.name);
        mob.setText(item.tel);

        layoutRoot.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {


            }
        });

    }