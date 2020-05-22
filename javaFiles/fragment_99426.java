//Create new marker
Drawable icon = this.getResources().getDrawable(R.drawable.marker);

//Set the bounding for the drawable
icon.setBounds(
    0 - icon.getIntrinsicWidth() / 2, 0 - icon.getIntrinsicHeight(), 
    icon.getIntrinsicWidth() / 2, 0);

//Set the new marker to the overlay
overlayItem.setMarker(icon);