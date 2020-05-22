private void DisplayAllMarkersonMap(GoogleSetGetArray googleSetGetArray) {
             try
                {
                    GeoPoint point = null;
                    for(int i=0;i<googleSetGetArray.getGoogleSetGets().size();i++)
                    {
                        //Drawable drawable = new BitmapDrawable(CheckIn.bitmaps.get(i));       //Drawables that are coming from google api
                        point = new GeoPoint((int) ((googleSetGetArray.getGoogleSetGets().get(i).getLat() * 1E6)),(int)((googleSetGetArray.getGoogleSetGets().get(i).getLng()) * 1E6));
                        overlayitem = new OverlayItem(point,googleSetGetArray.getGoogleSetGets().get(i).getName(), 
                        googleSetGetArray.getGoogleSetGets().get(i).getVicinity());
                        itemizedoverlay = new CheckInMapItemizedOverlay(drawable,mapView,true,googleSetGetArray.getGoogleSetGets().get(i).getId());
                        itemizedoverlay.addOverlay(overlayitem);
                        mapOverlays.add(itemizedoverlay);
                    }
                     mapController.animateTo(point);

                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
        }