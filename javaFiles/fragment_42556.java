public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_timeline, tv_website;
        private LinearLayout title; 

        public MyViewHolder(View view) {
            super(view);
            title = (LinearLayout) view.findViewById(R.id.title);
            tv_timeline = (TextView) view.findViewById(R.id.timeline);
            tv_website = (TextView) view.findViewById(R.id.website);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_row_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

      holder.tv_timeline.setText(mtimelineList.get(position));
      holder.tv_website.setText(mSiteSrc.get(position));
      for(int i = 0; i < 5; i++) { // 5 is the count how many times you want to add textview
          LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
          TextView tv=new TextView(holder.title.getContext());
          tv.setLayoutParams(lparams);
          tv.setText("test = "+i);
          holder.title.addView(tv);
}

    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }