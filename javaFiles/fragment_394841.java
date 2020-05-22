// =====For showing restaurant location======================//
    public void showFoodJoint(String foodJointId,double foodJointLat, double foodJointLon, String foodJointName, String foodJointDescription)
    {
        Drawable restaurantLocationDrawable = this.getResources().getDrawable(
                R.drawable.pin_for_restaurant_location);
        MapItemizedOverlay itemizedoverlayForRestaurant = new MapItemizedOverlay(
                restaurantLocationDrawable, this);

        GeoPoint myPoint1 = new GeoPoint(foodJointLat, foodJointLon);
        OverlayItem overlayitem2 = new OverlayItem(foodJointId,foodJointName,foodJointDescription, myPoint1);

        itemizedoverlayForRestaurant.addOverlay(overlayitem2);

        mapOverlays.add(itemizedoverlayForRestaurant);
    }

    // =====For showing restaurant location======================//