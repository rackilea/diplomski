...
if(sampleTry.getWeb().isEmpty() || sampleTry.getWeb() == null){
  holder.imageView.setImageResource(sampleTry.getImagesId());
  holder.imageView.setVisibility(View.VISIBLE);      
  holder.textView.setVisibility(View.GONE);
}else{
  holder.textView.setText(sampleTry.getWeb());
  holder.imageView.setVisibility(View.GONE);
  holder.textView.setVisibility(View.VISIBLE);
}
...