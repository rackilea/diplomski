/**
 * @hide - hide this constructor because it has a parameter
 * of type ILocationManager, which is a system private class. The
 * right way to create an instance of this class is using the
 * factory Context.getSystemService.
 */
public LocationManager(Context context, ILocationManager service) {
    mService = service;
    mContext = context;
}