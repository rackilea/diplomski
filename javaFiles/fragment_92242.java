@Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_row, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }