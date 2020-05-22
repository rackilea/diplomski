public  List<String> getBusRoute(String bus)                                                             //ThisIsWorkingAsExpected(SoDontChange)
{
    List<String> BusRouteList = new ArrayList<String>();

    try {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor CursorBusRoute = db.query("MDUBusRoutes", new String[] {"From_Loc","To_Loc","Route_1","Route_2","Route_3","Route_4","Route_5","Route_6","Route_7","Route_8","Route_9","Route_10","Route_11","Route_12","Route_13","Route_14","Route_15"}, "Bus_No_Type=?", new String[] { bus }, null, null, null, null);
        if (CursorBusRoute.moveToFirst()) {
            do {
                BusRouteList.add(CursorBusRoute.getString(2));
            }
            while (CursorBusRoute.moveToNext());
        }
        CursorBusRoute.close();
        db.close();
    }
    catch (Exception ignored){

    }
    return BusRouteList;
}