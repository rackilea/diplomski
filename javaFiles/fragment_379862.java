import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.bonuspack.overlays.Marker.OnMarkerDragListener;
import org.osmdroid.util.GeoPoint;

public static void applyDraggableListener(Marker poiMarker) {
        poiMarker.setDraggable(true);
        poiMarker.setOnMarkerDragListener(new OnMarkerDragListener() {
                @Override
                public void onMarkerDragStart(Marker marker) {}

                @Override
                public void onMarkerDragEnd(Marker marker) {
                        GeoPoint geopoint = marker.getPosition();        
                }

                @Override
                public void onMarkerDrag(Marker marker) {}
        });                
}