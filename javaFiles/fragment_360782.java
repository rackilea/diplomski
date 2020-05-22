List<Dessert> persons;
Context context
DessertAdapter(Context context, List<Dessert> persons)
{
  this.persons = persons;
  this.context = context;
}

...

@Override
public void onBindViewHolder(DessertVh dessertVh, int i){
   ...

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri url = Uri.parse("vnd.youtube://" + video_id); // get your url from list item or your code.
            Intent intent = new Intent(Intent.ACTION_VIEW, url);
            context.startActivity(intent);
        }
    });
    }