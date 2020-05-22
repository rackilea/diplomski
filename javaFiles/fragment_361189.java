@Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_one, container, false);

            ImageButton imageButton= (ImageButton ) view.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(this, WebActivity.class);
                 startActivity(intent);
            }
        });
            return view;
        }

    }