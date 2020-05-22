public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ImageButton whBtn = null;
            ImageButton fbBtn = null;
            ImageButton twBtn = null;

            if(null == view)
            {
                LayoutInflater vi = (LayoutInflater)rssfeedFragment.this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(R.layout.rssitemview, null);
                whBtn = (ImageButton) view.findViewById(R.id.whBtn);
                fbBtn = (ImageButton) view.findViewById(R.id.fbBtn);
                twBtn = (ImageButton) view.findViewById(R.id.twBtn);
            }

            if (whBtn != null) {
                whBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Code goes here
                        }
                    }
                });
            }

            if (fbBtn != null) {
                fbBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Code goes here
                        }
                    }
                });
            }

            if (twBtn != null) {
                twBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Code goes here
                        }
                    }
                });
            }