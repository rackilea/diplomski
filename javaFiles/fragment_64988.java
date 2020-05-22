...
@Override
public boolean onMarkerClick(Marker marker) {
    MarkerKind kind = (MarkerKind) marker.getTag();
    if (kind.id == MARKER_KIND1) {
        doSomething(marker);
    } else {
        doSomethingElse(marker);
    }
    return true;
}
...