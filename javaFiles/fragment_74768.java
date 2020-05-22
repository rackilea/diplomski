@Override
public void onBindViewHolder(@NonNull AllPostViewHolder allPostViewHolder, int i)
{
    Post post = postArrayList.get(i)
    holder.name.setText(post.getName());
    holder.email.setText(post.getEmail());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , YourIntent.class);
            intent.putExtra("Key" , post.getKey());
            holder.itemView.getContext().startActivity(intent);
        }
    });
}