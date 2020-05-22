@Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.xxxxx, parent, false);
        ViewHolder vh = new ViewHolder(v, new CustomEditTextListener());

        return vh;
    }