@Override
    public Object instantiateItem(View collection, int position) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int resId = 0;
        View view = null;
        switch (position) {

        case 0:
            view = inflater.inflate(R.layout.splash2, null);
            b = (Button) view.findViewById(R.id.splashB);
            b.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                                        //setContentView(r.layout.someLayout);
                }
            });
            break;
        case 1:
            view = inflater.inflate(R.layout.splash3, null);
            break;
        case 2:
            view = inflater.inflate(R.layout.splash4, null);
            break;
        case 3:
            view = inflater.inflate(R.layout.splash5, null);
            break;

        }


        ((ViewPager) collection).addView(view, 0);
        return view;
    }