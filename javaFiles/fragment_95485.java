map.setMapListener(new DelayedMapListener(new MapListener() {

        @Override
        public boolean onScroll(ScrollEvent paramScrollEvent) {
            // public boolean onDrag(boolean b) {
            IGeoPoint ij = map.getMapCenter();
            Double lat = ij.getLatitude();
            Double lon = ij.getLongitude();

           Toast.makeText(ctx, lat+","+lon, Toast.LENGTH_SHORT).show();


            return true;
        }


       @Override
       public boolean onZoom(ZoomEvent event) {
           return false;
       }

   }));