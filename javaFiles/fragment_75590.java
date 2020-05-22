@Override
public boolean onMarkerClick(Marker marker)
{
    Toast.makeText(getApplicationContext(), "Yout current location is"+marker.getTitle(), Toast.LENGTH_LONG).show();
    return false;
}