public class DirectionsAsync extends AsyncTask <String, Void, Integer> {

String startPoint;
String endPoint;

public DirectionsAsync(String start, String end) {
    startPoint = start;
    endPoint = end;
}