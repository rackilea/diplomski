Button button=(Button)findViewById(R.id.button);
    button.setOnClickListener(this);

    public void onClick(View v) {
    // TODO Auto-generated method stub
    switch(v.getId())
    {
    case R.id.button:
    ActivityYouwantToOpen.onOpen(v);
        break;
        }
        }