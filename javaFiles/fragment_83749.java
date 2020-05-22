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