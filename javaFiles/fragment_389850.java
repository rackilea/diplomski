import java.util.Calendar

ImageView imageView;

Calendar cal = Calendar.getInstance();

cal.setTime(now_date);

imageView = (ImageView)findViewById(R.id.imageView);

if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){

   imageView.setImageResource(R.drawable.IMAGE1);
 }else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
    imageView.setImageResource(R.drawable.IMAGE2);
}
....