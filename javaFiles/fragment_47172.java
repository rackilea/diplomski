private final View myContentsView;


    MyInfoWindowAdapter(){
        myContentsView = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
    }

    @Override
    public View getInfoContents(Marker marker) {

        //TODO getInfoContents
        TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title));
        tvTitle.setText(marker.getTitle());

        TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet));
        tvSnippet.setText(marker.getSnippet());

   //     private static HashMap<String, MarkerOptions> mMapMarkers = null;
        String landline = "";
        String mobile = "";
        String fax = "";
        for (int i = 0; i < extraMarkerInfo.size(); i++) {
            if (extraMarkerInfo.get(i).get("title").toString().equalsIgnoreCase(marker.getTitle()))
            {
                landline = extraMarkerInfo.get(i).get("landline").toString();
                Log.i("get_Landline", landline);
                mobile = extraMarkerInfo.get(i).get("mobile").toString();
                Log.i("get_Mobile", mobile);
                fax = extraMarkerInfo.get(i).get("fax").toString();
                Log.i("get_Fax", fax);
            }
        }

        TextView tvLandline = ((TextView)myContentsView.findViewById(R.id.landline_number));
        tvLandline.setText(landline);

        TextView tvMobile = ((TextView)myContentsView.findViewById(R.id.mobile_number));
        tvMobile.setText(mobile);

        TextView tvFax = ((TextView)myContentsView.findViewById(R.id.fax_number));
        tvFax.setText(fax);

        return myContentsView;
    }
    @Override
    public View getInfoWindow(Marker arg0) {
        // TODO Auto-generated method stub

        return null;
    }

}