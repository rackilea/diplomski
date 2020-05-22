ArrayList<Data> dynamicData=getData();
    if(dynamicData!=null)
    {
        for(int i=0;i<dynamicData.size();i++)
        {
            Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
            CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(drawable, this);

            //GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
            GeoPoint point = new GeoPoint((int)(Double.parseDouble(dynamicData.get(i).lat) * 1e6),(int)(Double.parseDouble(dynamicData.get(i).lon) * 1e6));
            OverlayItem overlayitem = new OverlayItem(point, "SML", "Shakarganj Mills Limited Jhang");

            itemizedOverlay.addOverlay(overlayitem);
            mapOverlays.add(itemizedOverlay);
        }
    }