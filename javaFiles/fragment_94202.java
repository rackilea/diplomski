infoButton.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                setContentView(R.layout.info_menu);
            }  // sholdn't be one here since its closing a method
        });