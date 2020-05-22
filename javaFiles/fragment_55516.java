class InfoClass implements Comparable<InfoClass> {

String name;
String place;
double distance;

@Override
public int compareTo(InfoClass o) {
    return new Double(this.distance).compareTo(new Double(o.distance));
}