public Geometry selectedBornes() {
    if (getSelectedRowIndex()> 0)
    {
     Geometry geometry;
     geometry = searchBorne().get(getSelectedRowIndex()).getGeometry();
     return geometry;
    }