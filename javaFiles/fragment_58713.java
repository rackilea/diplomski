TextView textview = (TextView) convertView.findById(R.id.txt); 
text.setText("textview");

Button btn  = (Button) convertView.findById(R.id.btn); 

btn.setTag(textview); 

btn.setOnClickListener(...)
{
   onClick(..){
      TextView t = (Textview)btn.getTag():
      t.setText("new value")

   }
}