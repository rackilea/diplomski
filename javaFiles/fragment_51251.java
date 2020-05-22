@Override
public void onClick( View view ) {
    fragmentManager.beginTransaction().replace( R.id.frame_container, new DayCalendarFragment() )
    .addToBackStack( null )
    .commit();        
}