@Override
public void onBindViewHolder(final MyViewHolder holder, final int position) {
    LoadDataResult listPotn = list.get(position);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Call intent or call method of Activity from here.

            Context context = v.getContext();
            Intent intent = new Intent(context , Excercise.class);
            context.startActivity(intent);
        }
    });
}