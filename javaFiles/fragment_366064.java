public List<Edge> adjacencies = new ArrayList<Edge>();

public Edge(Parcel in) {
    name = in.getString();
    minDistance = in.getDouble();
    adjancencies = in.readParcelableArray(Edge.getClass().getClassLoader()); 
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeDouble(minDistance);
    pc.writeParcelableArray((ArrayList<? extends Parcelable>) adjacencies, flags);

}