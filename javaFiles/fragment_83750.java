public void onBindViewHolder(final ViewHolder holder, int position) {
  Get_Set_Note movie=moviesList.get(position); 
  holder.title.setText(movie.getTitle()); 
  holder.time.setText(movie.getTime());

  if(movie.isFavorite){
    holder.imageView.setImageResource(R.drawable.btn_star_big_on); 
  }else{
    holder.imageView.setImageResource(R.drawable.btn_star_big_off); 
  }

  holder.imageView.setOnClickListener(new View.OnClickListener() { 
       @Override public void onClick(View v) {
         if(movie.isFavorite){ 
              movie.isFavorite = false
         }else{
             movie.isFavorite = true  
         }
          notifyDataSetChanged()
     }
  });
}