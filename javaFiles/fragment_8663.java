@Override
public boolean onTouch(View view, MotionEvent event)
{
    //note, that here the view parameter is the view the touch event has been dispatched to
    final TextView tv = (TextView)findViewById(R.id.myTextView);
    tv.setText(event.toString());
    return true; //or false, if you are dealing further with this event in parent classes
}