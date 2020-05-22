mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Data data = hashMap.get(marker);
                if(data!=null){
                    Intent intent = new Intent(mContext, YourActivity.class);
                    intent.putExtra(YourActivity.EXTRA_MESSAGE, data);
                    mContext.startActivity(intent);
                }
            }
        });