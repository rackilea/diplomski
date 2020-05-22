List list = this.mapView.getOverlays();
for(int i = 0:i<list.size();i++){
    Overlay o  = (Overlay) list.get(i);
    if (o instanceof GestionaleItemizedOverlay)
    {
        this.mapView.getOverlays().remove(o);//this one
    }
}